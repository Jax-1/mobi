package com.mobi.dao.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
      /**
       * 主键
       *
       * @return
       */
      boolean primaryKey() default false;
      /**
       * 唯一键
       *
       * @return
       */
      boolean unique() default false;
      /**
       * 自增
       *
       * @return
       */
      boolean generated() default false;
      /**
       * 允许为空
       *
       * @return
       */
      boolean allowNull() default true;
      /**
       * 允许修改
       * @return
       */
      boolean allowModify() default true;
      /**
       * 表中存在默认值
       * @return
       */
      boolean columnDef() default false;
      
}