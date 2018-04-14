package com.mobi.dao.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
      /**
       * ��ռ�
       * @return
       */
      public String schema() default "BPMDB";
      /**
       * ����
       * @return
       */
      public String name();
      /**
       * union����
       * @return
       */
      public String unionTable() default "";
      /**
       * ��ע��
       * @return
       */
      public String comment() default "";
}
