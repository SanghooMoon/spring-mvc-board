package com.mycom.soloProject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component	// 스프링이 시작될 때 컨테이너에 해당 클래스를 주입
@Aspect		// Aop임을 나타내는 어노테이션
public class TimeTraceAop {
	
	@Around("execution(* com.mycom.soloProject.board.controller..*(..))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println("=====================================================================");
		System.out.println("Start: " + joinPoint.toString());
		
		try {
			return joinPoint.proceed(); // 메서드를 실행
		} finally {
			long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
    		System.out.println("=====================================================================");
		}
	}
	
//	@After("execution(* com.mycom.soloProject.board.controller..*(..))")
//	public void after(){
//		System.out.println("테스트");
//	}

}
