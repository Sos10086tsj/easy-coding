package com.chinesedreamer.easycoding.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 防止重复提交注解
 * Auth:Paris
 * Date:Nov 25, 2016
**/
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidDuplicateSubmission {
	public boolean needAddToken() default false;
	public boolean needRemoveToken() default false;
}
