package com.tavant.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggerAspect {
	final Logger logger = Logger.getLogger(this.getClass());
	
	@AfterThrowing(pointcut = "execution(* com.tavant.service.*.*(..))",throwing = "exception")
	 public void afterThrowingAdvice(JoinPoint joinPoint,Exception exception){
			logger.error("This is error : " + exception.toString());
	}
}
