package com.zzz.hathor.cache.util.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
@Documented 
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SimpleCache {
	String key() default "";
	
	ExpireType policy() default ExpireType.TIME;
	
	long expireTime() default -1;
	
	TimeUnit unit() default TimeUnit.MILLISECONDS;
	
	Resources resources();
}
