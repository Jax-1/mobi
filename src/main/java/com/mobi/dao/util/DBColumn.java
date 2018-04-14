package com.mobi.dao.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBColumn {
      String table() default "";
      /**
       * 列名
       * @return
       */
      String name() default "";
      
      /**
       * 数据类型
       * @return
       */
      Type dataType() default Type.String;
      /**
       * (读)
       * @return
       */
      String setMethod();
      /**
       * (写)
       * @return
       */
      String getMethod() default "";
      /**
       * 约束条件
       * @return
       */
      Constraints constraint() default @Constraints;
      
      /**
       * 列描述
       * @return
       */
      String comments() default "";
      
}