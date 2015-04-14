package com.isigroup.cap.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.iisigroup.cap.base.CapFunctionCode;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CapAuditLogAction {
    CapActionTypeEnum actionType() default CapActionTypeEnum.Update;

    CapFunctionCode functionCode() default CapFunctionCode.F101;

    String name() default "";

    public enum CapActionTypeEnum {
        Add, Update, Delete, Query, Export, Import;
    }
}
