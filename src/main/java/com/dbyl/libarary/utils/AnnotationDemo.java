package com.dbyl.libarary.utils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDemo {
	String name();
	Class<Long> className();
	int id() default 0;
}
