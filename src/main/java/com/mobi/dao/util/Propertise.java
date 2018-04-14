package com.mobi.dao.util;

/**
 * 数据库常量参数
 * @author dell
 *
 */
public class Propertise {
    /** static属性的变量声明 */
    public static String DATASOURCE = "jdbc/BPMDB";
    public static String DATASOURCE_BACK_UP = "jdbc/BPMDB";//备用数据源，BPMDB数据源获取连接失败的情况下使用该数据源
    public static String DATA_SCHEMA = "BPMDB";
    public static String DATASOURCE_PRIVATE = "";
    public static String DATA_SCHEMA_PRIVATE = "";
    public static String DATASOURCEXCEPTION = "获取数据源失败,请检查数据源是否已启动";
    public static String DATABASEXCEPTION = "数据库连接异常,请联系系统管理员";
    public static String UNKWONEXCEPTION = "未知错误,请联系系统管理员";
    public static String UMEXCEPTION = "用户管理UME异常";
    public static String DB_TYPE = DBTypeConstants.ORACLE;

}
