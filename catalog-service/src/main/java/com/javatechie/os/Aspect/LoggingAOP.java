package com.javatechie.os.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAOP {

	private static final Logger log = LoggerFactory.getLogger(LoggingAOP.class);

	@Pointcut(value = "execution(* com.javatechie.os.*.*.*(..))")
	public void PointCut() {

	}

	@Around("PointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String Methodname = pjp.getSignature().getName();
		String Classname = pjp.getTarget().getClass().getName();
		Object arr[] = pjp.getArgs();
		log.info(" ClassName : " + Classname + "," + " MethodName : " + Methodname + "(), " + " Arguments are "
				+ mapper.writeValueAsString(arr));
		Object obj = pjp.proceed();
		log.info(" ClassName : " + Classname + "," + " MethodName : " + Methodname + "(), " + " Object are "
				+ mapper.writeValueAsString(obj));
		return obj;
	}

}
