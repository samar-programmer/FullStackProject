package com.revature.projects.shopper.utility;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	Logger log=Logger.getLogger("LogAspects");
	
	@Before("execution(* com.revature.projects.shopper.controller..*(..))")
	public void display() {
		log.info("before execusion of ");
	}
	
	@After("execution(* com.revature.projects.shopper.controller..*(..))")
	public void display1() {
		log.info("after execusion");
	}
	
//	@Around("execution(* com.revature.projects.shopper.controller..*(..))")
//	public void display2(ProceedingJoinPoint pjp) {
//		log.info("during execusion"+pjp.getStaticPart().getSignature().getName());
//	}
}
