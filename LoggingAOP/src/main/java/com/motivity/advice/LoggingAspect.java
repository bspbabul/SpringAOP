package com.motivity.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut(value = "execution(* com.motivity.service.*.*(..)) || execution(* com.motivity.controller.*.*(..))")
	public void PointCut() {

	}

	@Around("PointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if (log.isDebugEnabled()) {
			log.debug("Enter: {}.{}() with arguments = {}", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		}
		try {
			Object result = joinPoint.proceed();
			if (log.isDebugEnabled()) {
				log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
						joinPoint.getSignature().getName(), result);

			}
			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
					joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
			throw e;
		}
	}

	@Around("PointCut()")
	public Object CalculateMethodsTimeExecution(ProceedingJoinPoint pjp) throws Throwable {

		long startTime = System.currentTimeMillis();
		try {
			Object result = pjp.proceed();
			long endTime = System.currentTimeMillis();
			long executionTime = endTime - startTime;
			if (log.isDebugEnabled()) {
				log.debug("{}.{}() execution time: {} ms", pjp.getSignature().getDeclaringTypeName(),
						pjp.getSignature().getName(), executionTime);
			}
			return result;
		} catch (Throwable throwable) {
			long endTime = System.currentTimeMillis();
			long executionTime = endTime - startTime;
			if (log.isDebugEnabled()) {
				log.debug("{}.{}() execution time: {} ms (exception occurred)",
						pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), executionTime);
			}
			throw throwable;
		}
	}
}
