package com.zzz.hathor.captcha.config.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Demo {
		@Around("@annotation(restRequestHelper)")
	public Object process(ProceedingJoinPoint pjp, RestRequestHelper restRequestHelper) {
		//do something
		System.out.println("hello");
		return restRequestHelper;
	}
}