package com.spring.booking.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//aop 구현
@Component
@Aspect
public class AopAdvice {
	//매개변수 출력
	// 리턴형(*) / 클래스명(org.spring.board.service.LoginServiceImpl) / 메소드명(.*) / 매개변수(..)
	@Before("execution(* com.spring.booking.controller.*.*(..))")
	public void startLogService(JoinPoint jp) {
		System.out.println("----------------------------------------");
		System.out.println(jp.getSignature().toLongString());
		System.out.println("(aop 매개변수) " + Arrays.toString(jp.getArgs()));
		System.out.println("----------------------------------------");
	}
	
	//리턴값 출력 / pointcut == 적용할 대상, JoinPoint == 실제 적용된
	//적용대상 정상수행 후 
	@AfterReturning(pointcut="execution(* com.spring.booking.service.*.*(..))", returning = "rObj")
	public void afterLongService(JoinPoint jp, Object rObj) {
		if (rObj != null) {
			System.out.println("----------------------------------------");
			System.out.println(jp.getSignature().toLongString());
			System.out.println("리턴값: " + rObj.toString());
			System.out.println("----------------------------------------");
		}
	}
	
	
	
	
	
	
	
	
	
}
