package com.mobi.dao.util;



import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

public class JdbcThread<T> implements Callable<String> {

    private static final Logger logger = Logger.getLogger(JdbcThread.class);
    private static final String RESULT_FAIL = "FAIL";

    private static final int threshold = 3000;
    private static final int poolSize=30;
    private final List<T> input;
    private final int start;
    private final Connection conn;
    private final Class<T> c;

    private JdbcThread(Connection conn, List<T> list, Class<T> c, int start) {
        this.conn = conn;
        this.input = list;
        this.c = c;
        this.start = start;
    }

    public String call() throws Exception {
        int size = this.input.size();
        int matchLength = size > (start + threshold) ? start + threshold : size;

        boolean result = true;
        List<T> list = new ArrayList<T>();

        for (int i = start; i < matchLength; i++) {
            list.add(input.get(i));
        }
        if (list.size() > 0) {
            result = JdbcExcuteUtil.merge(conn, c, list);
        }
        if (!result) {
            return RESULT_FAIL;
        }
        return null;
    }

    public synchronized static boolean execute(Connection conn, List<?> list, Class<?> c) {
        boolean success = true;
        List<Future<String>> result;
        Collection<JdbcThread<?>> tasks = new ArrayList<JdbcThread<?>>();
        
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        int length = list.size();
        int size = (length / threshold) + (length % threshold > 0 ? 1 : 0);
        for (int i = 0; i < size; i++) {
            tasks.add(new JdbcThread(conn, list, c, i * threshold));
        }
        if (tasks.size() == 0) {
            return success;
        }
        try {
            result = executor.invokeAll(tasks);
            while (true) {
                boolean out = true, fail = false;
                for (Future<String> future : result) {
                    if (!future.isDone()) {
                        out = false;
                    } else {
                        if (RESULT_FAIL.equals(future.get())) {
                            fail = true;
                        }
                    }
                }
                if (out) {
                    if (fail) {
                        success = false;
                    }
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally{
            executor.shutdown();
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
        return success;
    }
}

