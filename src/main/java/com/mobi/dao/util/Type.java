package com.mobi.dao.util;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
public enum Type {
      
      String("getString",String.class,"setString", String.class),
      Integer("getInt",Integer.class,"setInt", int.class),
      Long("getLong",Long.class,"setLong", long.class),
      Timestamp("getTimestamp",Timestamp.class,"setTimestamp",Timestamp.class),
      Date("getDate",Date.class,"setDate",Date.class),
      BigDecimal("getBigDecimal",BigDecimal.class,"setBigDecimal",BigDecimal.class),
      Boolean("getBoolean",Boolean.class,"setInt",int.class),
      Bytes("getBlob",Blob.class,"setBytes",byte[].class);
      
      /**
       * (��)ResultSet��get����
       */
      private String getMethod;
      /**
       * (д)PreparedStatement��set����
       */
      private String setMethod;
      /**
       * ��������
       */
      private Class<?> classType;
      /**
       * Column����
       */
      private Class<?> columnType;
      private Type(String getMethod, Class<?> classType,String setMethod,Class<?>columnType) {
            this.getMethod = getMethod;
            this.classType = classType;
            this.setMethod = setMethod;
            this.columnType = columnType;
      }
      public Class<?> getClassType() {
            return classType;
      }
      public Class<?> getColumnType() {
            return columnType;
      }
      public String getMethod() {
            return getMethod;
      }
      public String setMethod() {
            return setMethod;
      }
}
