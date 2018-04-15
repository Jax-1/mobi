

package com.mobi.dao.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mobi.util.Validate;

public class JdbcExcuteUtil {
	private static Logger logger = Logger.getLogger(JdbcExcuteUtil.class); 
      
      private static final int BATCH_SIZE = 1000;
      
      
      public static List query(Connection conn, Object object, String sql) {
            return null;
      }
      
      public static boolean save(Connection conn, Class<?> c,
                  List<?> insertList) throws Exception {
            boolean success = false;
            DBTable dbTable = c.getAnnotation(DBTable.class);
            if (null == insertList || insertList.size() <= 0 ||null == dbTable) {
                  return false;
            }
            String SQL_FIND = "INSERT INTO " + dbTable.schema() + "." + dbTable.name() + " (%s)VALUES(%s)";
            String[] placeHolders = savePlaceHolders(c);
            if (null == placeHolders) {
                  return false;
            }
            String sql = String.format(SQL_FIND, placeHolders[0], placeHolders[1]);
            
            PreparedStatement pstm = null;
            try {
                  pstm = conn.prepareStatement(sql);
                  for (Object object : insertList) {
                        savePrepareValue(pstm, object);
                        pstm.addBatch();
                  }
                  int[] count = pstm.executeBatch();
                  if (count.length > 0) {
                        success = true;
                  }
            } catch (Exception e) {
//                  logger.debug("JdbcExcuteUtil.save方法异常："+e.getMessage());
//                  throw new BPMException(e.getMessage());
            }finally{
                  DBConnection.freeConnection(pstm);
            }
            return success;
      }
      
      
      /**
       * @Description: 查询全表
       * @author       LXD
       * @Create at:   Nov 23, 20158:13:52 PM
       * @Modified by:
       */
      @SuppressWarnings("unchecked")
      public static synchronized <E> List<E> queryAll(Connection conn, Class<?> c) {
            List<E> list = new ArrayList<E>();
            ResultSet rs = null;
            PreparedStatement pstm = null;
            DBTable table = c.getAnnotation(DBTable.class);
            String sql="SELECT * FROM "+table.schema()+"."+table.name();
            try {
                  pstm = conn.prepareStatement(sql);
                  rs = pstm.executeQuery();
                  while (rs.next()) {
                        Object obj=getMyObject(c, rs);
                        list.add((E)obj);
                  }
            } catch (Exception e) {
//                  logger.debug("JdbcExcuteUtil.queryAll方法异常。SQL：" + sql);
            } finally {
                  DBConnection.freeConnection(pstm, rs);
            }
            return list;
      }
      
      /**
       * @Description: 按preparedStatement 方式查询
       * @author       ZHANG
       * @Create 
       * @Modified by:
       */
      @SuppressWarnings("unchecked")
      public static synchronized <E> List<E> queryList (String sql,List<SQLParam> sqlParams,Class<E> cls,Connection conn) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
            List<E> answer=new ArrayList<E>();
            PreparedStatement pstmt=null;
            ResultSet rs =null;
            try{
                  pstmt=conn.prepareStatement(sql);
                  SQLParam.setParams(pstmt, sqlParams);
                  rs=pstmt.executeQuery();
                  while(rs.next()){
                        Object obj=getMyObject(cls, rs);
                        answer.add((E)obj);
                  }
                  return answer;
            }finally{
                  if (pstmt!=null)
                        try{
                              pstmt.close();
                        }catch(Exception e){
//                              logger.debug("JdbcExcuteUtil.queryList exception:"+e.getMessage());
                        }
                        if (rs!=null)
                              try{
                                    rs.close();
                              }catch(Exception e){
//                                    logger.debug("JdbcExcuteUtil.queryList exception:"+e.getMessage());
                              }
            }
      }
      
      public static synchronized <E> List<E> queryTop (String sql,List<SQLParam> sqlParams,
                  Class<E> cls,int rowNum,Connection conn) throws SQLException,IllegalAccessException,InstantiationException,InvocationTargetException{
            List<E> answer=new ArrayList<E>();
            PreparedStatement pstmt=null;
            ResultSet rs =null;
            if(DBTypeConstants.SQL_SERVER.equals(Propertise.DB_TYPE)){
                  int selectIdx=sql.toUpperCase().indexOf("SELECT");
                  sql="SELECT TOP "+rowNum+" "+sql.substring(selectIdx+6);
            }else if(DBTypeConstants.ORACLE.equals(Propertise.DB_TYPE)){
                  
            }
            System.out.println("查询前几行SQL:"+sql);
            try{
                  pstmt=conn.prepareStatement(sql);
                  SQLParam.setParams(pstmt, sqlParams);
                  rs=pstmt.executeQuery();
                  while(rs.next()){
                        Object obj=getMyObject(cls, rs);
                        answer.add((E)obj);
                  }
                  return answer;
            }finally{
                  if (pstmt!=null)
                        try{
                              pstmt.close();
                        }catch(Exception e){
//                              logger.debug("JdbcExcuteUtil.queryTop exception:"+e.getMessage());
                        }
                        if (rs!=null)
                              try{
                                    rs.close();
                              }catch(Exception e){
//                                    logger.debug("JdbcExcuteUtil.queryTop exception:"+e.getMessage());
                              }
            }
      }
      
      
      /**
       * 根据主键更新
       *
       * @param conn
       * @param c
       * @param updateList
       * @return
       * @throws SQLException
       * @throws IllegalArgumentException
       * @throws IllegalAccessException
       * @throws InvocationTargetException
       */
      public static boolean update(Connection conn, Class<?> c,
                  List<?> updateList) throws SQLException,
                  IllegalArgumentException, IllegalAccessException,
                  InvocationTargetException {
            boolean success = false;
            DBTable dbTable = c.getAnnotation(DBTable.class);
            if (null == updateList || updateList.size() <= 0 || null == dbTable) {
                  return false;
            }
            String SQL_FIND = "UPDATE " + dbTable.schema() + "." + dbTable.name()
                        + " SET %s WHERE %s";
            List<DBColumn>columns=new ArrayList<DBColumn>();
            String[] placeHolders = updatePlaceHolders(c,columns,true);
            if (null == placeHolders) {
                  return false;
            }
            String sql = String.format(SQL_FIND, placeHolders[0], placeHolders[1]);
            PreparedStatement pstm = null;
            try {
                  pstm = conn.prepareStatement(sql);
                  for (Object object : updateList) {
                        prepareValue(pstm, object,columns);
                        pstm.addBatch();
                  }
                  int[] count = pstm.executeBatch();
                  if (count.length > 0) {
                        success = true;
                  }
            } catch (Exception e) {
                  logger.debug("JdbcExcuteUtil.update方法异常："+e.getMessage());
            }finally{
                  DBConnection.freeConnection(pstm);
            }
            return success;
      }
      
      /**
       * 根据主键删除
       * @param conn
       * @param c
       * @param deleteList
       * @return
       * @throws SQLException
       * @throws IllegalArgumentException
       * @throws IllegalAccessException
       * @throws InvocationTargetException
       */
      public static boolean delete(Connection conn, Class<?> c,
                  List<?> deleteList) throws SQLException,
                  IllegalArgumentException, IllegalAccessException,
                  InvocationTargetException {
            boolean success = false;
            DBTable dbTable = c.getAnnotation(DBTable.class);
            if (null == deleteList || deleteList.size() <= 0 || null == dbTable) {
                  return false;
            }
            String SQL_FIND = "DELETE " + dbTable.schema() + "." + dbTable.name()+ " WHERE %s";
            List<DBColumn>columns=new ArrayList<DBColumn>();
            String[] placeHolders = updatePlaceHolders(c,columns,false);
            if (null == placeHolders) {
                  return false;
            }
            String sql = String.format(SQL_FIND, placeHolders[1]);
            
            PreparedStatement pstm = null;
            try {
                  pstm = conn.prepareStatement(sql);
                  for (Object object : deleteList) {
                        prepareValue(pstm, object,columns);
                        pstm.addBatch();
                  }
                  int[] count = pstm.executeBatch();
                  if (count.length > 0) {
                        success = true;
                  }
            } catch (Exception e) {
//                  logger.debug("JdbcExcuteUtil.delete方法异常："+e.getMessage());
                  DBConnection.freeConnection(pstm);
            }
            return success;
      }
      
      
      /**
       *
       * @Description:批量执行保存、更新操作
       * @param      :
       * @author     :LXD
       * @Create at  :Dec 25, 2015 4:33:18 PM
       * @Modified by:
       */
      public static boolean executeSQLs(List<String> sqlList,Connection conn)throws Exception {
            if(null== sqlList || sqlList.size()<=0) {
                  return false;
            }
            ResultSet rs = null;
            Statement stmt = null;
            boolean result = true;
            try {
                  int total = sqlList.size();
                  int num = 0;
                  int times = total / BATCH_SIZE + 1;
                  
                  int page = 0;
                  while (page < times) {
                        //每1000条记录批量执行一次
                        while (num < total && num < (BATCH_SIZE + page * BATCH_SIZE)) {
                              try {
                                    stmt = conn.createStatement();
                                    
                                    stmt.addBatch(sqlList.get(num));
                                    
                                    stmt.executeBatch();
                                    
                                    num++;
                              } finally {
                                    if (stmt != null)
                                          stmt.close();
                              }
                        }
                        page++;
                  }
            } catch (Exception e) {
                  result = false;
                  throw e;
            } finally {
                  DBConnection.freeConnection( stmt, rs);
            }
            return result;
      }
      
      
      public synchronized static boolean merge(Connection conn, Class<?> c,
                  List<?> list) throws IllegalArgumentException,
                  IllegalAccessException, InvocationTargetException, SQLException {
            boolean success = false;
            DBTable dbTable = c.getAnnotation(DBTable.class);
            if (null == list || list.size() <= 0 ||null == dbTable) {
                  return false;
            }
            String SQL_FIND = "MERGE INTO "
                        + dbTable.schema()+ "."+ dbTable.name()
                        + " t using (select %s from dual)r on (%s)when matched then update set %s when not matched then insert(%s) values(%s)";// WHERE r.VERSION_TIME is null
            String[] placeHolders = mergePlaceHolders(c);
            if (null == placeHolders) {
                  return false;
            }
            String sql = String.format(SQL_FIND, placeHolders[0], placeHolders[1],
                        placeHolders[2], placeHolders[3], placeHolders[4]);
            
            PreparedStatement pstm = null;
            try {
                  pstm = conn.prepareStatement(sql);
                  for (Object object : list) {
                        mergePrepareValue(pstm, object);
                        pstm.addBatch();
                  }
                  int[] count = pstm.executeBatch();
                  if (count.length > 0) {
                        success = true;
                  }
            } catch (Exception e) {
//                  logger.debug("JDBCEXCUTEUITL EXCEPTION-MERGE: "+e.getMessage());
            }finally{
                  DBConnection.freeConnection(pstm);
            }
            return success;
      }
      
//      public static boolean merge(Connection conn, Class<?> c,
//                  List<?> list,JdbcPrepared p) throws IllegalArgumentException,
//                  IllegalAccessException, InvocationTargetException, SQLException {
//            boolean success = false;
//            DBTable dbTable = c.getAnnotation(DBTable.class);
//            if (null == list || list.size() <= 0 ||null == dbTable) {
//                  return false;
//            }
//            PreparedStatement pstm = null;
//            try {
//                  pstm = conn.prepareStatement(p.mergeSql());
//                  for (Object object : list) {
//                        p.callPrepared(pstm, object);
//                        pstm.addBatch();
//                  }
//                  int[] count = pstm.executeBatch();
//                  if (count.length > 0) {
//                        success = true;
//                  }
//            } catch (Exception e) {
////                  logger.debug("JDBCEXCUTEUITL EXCEPTION-MERGE: "+e.getMessage());
//                  
//            }finally{
//                  DBConnection.freeConnection(pstm);
//            }
//            return success;
//      }
      
      
      public static boolean mergeThread(Connection conn, Class<?> c,
                  List<?> insertList) {
            return JdbcThread.execute(conn, insertList, c);
      }
      
      public static String getSelfColumns(Class c) {
            StringBuffer result=new StringBuffer();
            boolean first=true;
            Field[] field = c.getDeclaredFields();
            for (Field f : field) {
                  DBColumn column = f.getAnnotation(DBColumn.class);
                  if (null != column&&Validate.notNull(column.getMethod())) {
                        if (first) {
                              result.append(column.name());
                        }else {
                              result.append(","+column.name());
                        }
                        first=false;
                  }
            }
            return result.toString();
      }
      
      public static Object getMyObject(Class<?> c, ResultSet rs) {
            Object object = initObject(c);
            Field[] field = c.getDeclaredFields();
            for (Field f : field) {
                  DBColumn column = f.getAnnotation(DBColumn.class);
                  if (null != column) {
                        if (!checkColumn(rs, column.name())) {
                              continue;
                        }
                        Method getMethod,setMethod;
                        try {
                              getMethod = ResultSet.class.getDeclaredMethod(column
                                          .dataType().getMethod(), new Class[] { String.class });
                              
                              setMethod = c.getDeclaredMethod(column.setMethod(),
                                          new Class[] { column.dataType().getClassType() });
                              Object rsValue;
                              try {
                                    rsValue = getMethod.invoke(rs, column.name());
                                    setMethod.invoke(object, rsValue);
                              } catch (IllegalArgumentException e) {
//                                    logger.debug("JDBCEXCUTEUITL getMyObject SecurityException:"+e.getMessage());
                              } catch (IllegalAccessException e) {
//                                    logger.debug("JDBCEXCUTEUITL getMyObject SecurityException:"+e.getMessage());
                              } catch (InvocationTargetException e) {
//                                    logger.debug("JDBCEXCUTEUITL getMyObject InvocationTargetException:"+column.name()+" / "+setMethod.getName());
                              }
                              
                        } catch (SecurityException e) {
//                              logger.debug("JDBCEXCUTEUITL getMyObject SecurityException:"+e.getMessage());
                        } catch (NoSuchMethodException e) {
//                              logger.debug("JDBCEXCUTEUITL getMyObject NoSuchMethodException:"+e.getMessage());
                        }
                        
                  }
            }
            return object;
      }
      
      public static Object initObject(Class<?> c) {
            Object object = null;
            try {
                  Constructor<?> cons = c.getConstructor();
                  object = cons.newInstance();
            } catch (SecurityException e) {
                  logger.debug("JDBCEXCUTEUITL initObject SecurityException:"+e.getMessage());
            } catch (NoSuchMethodException e) {
                  logger.debug("JDBCEXCUTEUITL initObject NoSuchMethodException:"+e.getMessage());
            } catch (IllegalArgumentException e) {
                  logger.debug("JDBCEXCUTEUITL initObject IllegalArgumentException:"+e.getMessage());
            } catch (InstantiationException e) {
                  logger.debug("JDBCEXCUTEUITL initObject InstantiationException:"+e.getMessage());
            } catch (IllegalAccessException e) {
                  logger.debug("JDBCEXCUTEUITL initObject IllegalAccessException:"+e.getMessage());
            } catch (InvocationTargetException e) {
                  logger.debug("JDBCEXCUTEUITL initObject InvocationTargetException:"+e.getMessage());
            }
            return object;
      }
      
      private static List<DBColumn> queryPlaceHolders(Object object){
            List<DBColumn>columns=new ArrayList<DBColumn>();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field f : fields) {
                  DBColumn column = f.getAnnotation(DBColumn.class);
                  if (null != column) {
                        Method getMethod;
                        try {
                              getMethod = object.getClass().getMethod(column.getMethod());
                              Object getValue;
                              try {
                                    getValue = getMethod.invoke(object, null);
                                    if (null != getValue) {
                                          columns.add(column);
                                    }
                              } catch (IllegalArgumentException e) {
                                    logger.debug("JDBCEXCUTEUITL queryPlaceHolders IllegalArgumentException:"+e.getMessage());
                              } catch (IllegalAccessException e) {
                                    logger.debug("JDBCEXCUTEUITL queryPlaceHolders IllegalAccessException:"+e.getMessage());
                              } catch (InvocationTargetException e) {
                                    logger.debug("JDBCEXCUTEUITL queryPlaceHolders InvocationTargetException:"+e.getMessage());
                              }
                        } catch (SecurityException e) {
                              logger.debug("JDBCEXCUTEUITL queryPlaceHolders SecurityException:"+e.getMessage());
                        } catch (NoSuchMethodException e) {
                              logger.debug("JDBCEXCUTEUITL queryPlaceHolders NoSuchMethodException:"+e.getMessage());
                        }
                  }
            }
            return columns;
      }
      
      private static String[] mergePlaceHolders(Class<?> c) {
            StringBuilder using = new StringBuilder();
            StringBuilder on = new StringBuilder();
            StringBuilder set = new StringBuilder();
            StringBuilder keys = new StringBuilder();
            StringBuilder vlaues = new StringBuilder();
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                  DBColumn column = f.getAnnotation(DBColumn.class);
                  if (null != column) {
                        if (readOnly(column, null)) {
                              continue;
                        }
                        String name = column.name();
                        // USING
                        if (using.length() > 0) {
                              using.append(",");
                        }
                        using.append(" ? as ").append(name);
                        if (column.constraint().primaryKey()) {// ON
                              if (on.length() > 0) {
                                    on.append(" and ");
                              }
                              on.append("t.").append(name).append("= r.").append(name);
                        } else if (!readOnly(column, false)) {// SET
                              if (set.length() > 0) {
                                    set.append(" , ");
                              }
                              set.append("t.").append(name).append("= r.").append(name);
                        }
                        // VALUES
                        if (!readOnly(column, true)) {
                              if (vlaues.length() > 0) {
                                    keys.append(" , ");
                                    vlaues.append(" , ");
                              }
                              keys.append(name);
                              vlaues.append("r.").append(name);
                        }
                  }
            }
            String[] placeHolders = null;
            if (using.length() > 0 && on.length() > 0 && set.length() > 0
                        && keys.length() > 0 && vlaues.length() > 0) {
                  placeHolders = new String[5];
                  placeHolders[0] = using.toString();
                  placeHolders[1] = on.toString();
                  placeHolders[2] = set.toString();
                  placeHolders[3] = keys.toString();
                  placeHolders[4] = vlaues.toString();
            }
            return placeHolders;
      }
      
      private static String[] savePlaceHolders(Class<?> c){
            StringBuilder fieldsPlaceHolders = new StringBuilder();
            StringBuilder preparePlaceHolders = new StringBuilder();
            boolean append=false;
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                  DBColumn column = f.getAnnotation(DBColumn.class);
                  if (null != column) {
                        if (readOnly(column,true)) {
                              continue;
                        }
                        if (append) {
                              fieldsPlaceHolders.append(",");
                              preparePlaceHolders.append(",");
                        }
                        fieldsPlaceHolders.append(column.name());
                        preparePlaceHolders.append("?");
                        
                        append=true;
                  }
            }
            String[]PlaceHolders=null;
            if (append) {
                  PlaceHolders=new String[2];
                  PlaceHolders[0]=fieldsPlaceHolders.toString();
                  PlaceHolders[1]=preparePlaceHolders.toString();
            }
            return PlaceHolders;
      }
      
      private static void savePrepareValue(PreparedStatement pstm,
                  Object object) throws Exception {
            int index = 0;
            Class<?> c = object.getClass();
            
            DBTable dbTable = c.getAnnotation(DBTable.class);
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                  DBColumn column = f.getAnnotation(DBColumn.class);
                  if (null != column) {
                        if (readOnly(column,true)) {
                              continue;
                        }
                        Method getMethod;
                        try {
                              getMethod = c.getMethod(column.getMethod());
                              if(null==getMethod){
//                                    throw new BPMException("未获取到"+c.getSimpleName()+"中"+column.getMethod()+"方法");
                              }
                              Object getValue = getMethod.invoke(object, null);
                              
                              Method setMethod = PreparedStatement.class.getDeclaredMethod(
                                          column.dataType().setMethod(), new Class<?>[] {
                                                int.class, column.dataType().getColumnType() });
                              if(null==setMethod){
//                                    throw new BPMException("未获取到"+c.getSimpleName()+"中"+column.getMethod()+"方法");
                              }
                              switch (column.dataType()) {
                              case Boolean:
                                    getValue=null==getValue?false:getValue;
                                    setMethod.invoke(pstm, ++index, (Boolean) getValue ? 1: 0);
                                    break;
                              default:
                                    try{
                                          setMethod.invoke(pstm, ++index, getValue);
                                    }catch(Exception e){
//                                          throw new BPMException(c.getSimpleName()+"中"+column.name()+"类型不匹配");
                                    }
                                    break;
                              }
                        } catch (Exception e) {
                              logger.debug("JdbcExcuteUtil.savePrepareValue方法异常："+e.getMessage());
                        }
                  }
            }
      }
      
      private static void mergePrepareValue(PreparedStatement pstm,
                  Object object) throws IllegalArgumentException,
                  IllegalAccessException, InvocationTargetException {
            int index = 0;
            Class<?> c = object.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                  DBColumn column = f.getAnnotation(DBColumn.class);
                  if (null != column) {
                        if (readOnly(column, null)) {
                              continue;
                        }
                        Method getMethod;
                        try {
                              getMethod = c.getMethod(column.getMethod());
                              Object getValue = getMethod.invoke(object, null);
                              
                              Method setMethod = PreparedStatement.class.getDeclaredMethod(
                                          column.dataType().setMethod(), new Class<?>[] {
                                                int.class, column.dataType().getColumnType() });
                              switch (column.dataType()) {
                              case Boolean:
                                    getValue=null==getValue?false:getValue;
                                    setMethod.invoke(pstm, ++index, (Boolean) getValue ? 1
                                                : 0);
                                    break;
                              default:
                                    setMethod.invoke(pstm, ++index, getValue);
                                    break;
                              }
                        } catch (SecurityException e) {
                              logger.debug("JDBCEXCUTEUITL mergePrepareValue SecurityException:"+e.getMessage());
                        } catch (NoSuchMethodException e) {
                              logger.debug("JDBCEXCUTEUITL mergePrepareValue NoSuchMethodException:"+e.getMessage());
                        }
                  }
            }
      }
      
      private static String[] updatePlaceHolders(Class<?> c,List<DBColumn>columns,boolean update){
            StringBuilder fieldsPlaceHolders = new StringBuilder();
            List<DBColumn>sets=new ArrayList<DBColumn>();
            StringBuilder conditPlaceHolders = new StringBuilder();
            List<DBColumn>condi=new ArrayList<DBColumn>();
            boolean append0=false;
            boolean append1=false;
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                  DBColumn column = f.getAnnotation(DBColumn.class);
                  if (null != column) {
                        if (column.constraint().primaryKey()) {
                              condi.add(column);
                              if (append1) {
                                    conditPlaceHolders.append(" AND ");
                              }
                              conditPlaceHolders.append(column.name()).append("=? ");
                              append1=true;
                        }
                        if (readOnly(column,false)) {
                              continue;
                        }
                        sets.add(column);
                        if (append0) {
                              fieldsPlaceHolders.append(",");
                        }
                        fieldsPlaceHolders.append(column.name()).append("=? ");
                        append0=true;
                  }
            }
            String[]PlaceHolders=null;
            if (append0) {
                  PlaceHolders=new String[2];
                  PlaceHolders[0]=fieldsPlaceHolders.toString();
                  PlaceHolders[1]=conditPlaceHolders.toString();
                  if (update) {
                        columns.addAll(sets);
                  }
                  columns.addAll(condi);
            }
            return PlaceHolders;
      }
      private static void prepareValue(PreparedStatement pstm,
                  Object object,List<DBColumn> columns) throws IllegalArgumentException,
                  IllegalAccessException, InvocationTargetException {
            int index = 0;
            for (DBColumn column : columns) {
                  Method getMethod;
                  try {
                        getMethod = object.getClass().getMethod(column.getMethod());
                        Object getValue = getMethod.invoke(object, null);
                        
                        Method setMethod = PreparedStatement.class.getDeclaredMethod(
                                    column.dataType().setMethod(), new Class<?>[] {
                                          int.class, column.dataType().getColumnType() });
                        switch (column.dataType()) {
                        case Boolean:
                              getValue=null==getValue?false:getValue;
                              setMethod.invoke(pstm, ++index, (Boolean) getValue ? 1 : 0);
                              break;
                        default:
                              setMethod.invoke(pstm, ++index, getValue);
                              break;
                        }
                  } catch (SecurityException e) {
                        logger.debug("JDBCEXCUTEUITL prepareValue SecurityException:"+e.getMessage());
                  } catch (NoSuchMethodException e) {
                        logger.debug("JDBCEXCUTEUITL prepareValue NoSuchMethodException:"+e.getMessage());
                  }
            }
      }
      
      private static boolean readOnly(DBColumn column,Boolean isSave){
            if (column.constraint().generated()&&null!=isSave) {// 自增的字段
                  return true;
            }
            if ("".equals(column.getMethod())) {// 只读的字段
                  return true;
            }
            if (null!=isSave) {
                  if (isSave) {
                        if (column.constraint().columnDef()) {//表中存在默认值
                              return true;
                        }
                  }else {
                        if (!column.constraint().allowModify()) {//是否能修改
                              return true;
                        }
                  }
            }
            return false;
      }
      
      private static Boolean checkColumn(ResultSet rs,String columnName) {
            ResultSetMetaData metaData;
            try {
                  metaData = rs.getMetaData();
                  int count = metaData.getColumnCount();
                  for (int i = 1; i <= count; i++) {
                        String name = metaData.getColumnName(i);
                        if (name.equals(columnName)) {
                              return true;
                        }
                  }
            } catch (SQLException e1) {
                  logger.debug("JDBCEXCUTEUITL checkColumn SQLException:"+e1.getMessage());
            }
            return false;
      }
      
      
      
      
      
      
      
      
}
