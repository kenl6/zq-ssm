package cn.dw.zq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Component
@Aspect
public class LogAop {
	
	@Pointcut("execution(* cn.dw.zq.controller.*.*(..))")
	public void log() {}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println("=============方法调用之前的操作=================");
	}
	
	@After("log()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("*******************方法调用结束*******************");
	}
	
	@Around("log()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//		获取开始时间
		long start = System.currentTimeMillis();
//		利用代理对象去调用对应的方法
		Object obj = pjp.proceed();
//		获取结束时间
		long end = System.currentTimeMillis();
//		打印方法的调用时间
		System.out.println("方法调用消耗时间：" + (end -start));
//		JSONObject json = JSONObject.parseObject(obj.toString());
//		/*统一处理数据*/
//		json.put("test", "111111111111");
		return obj;
	}
	
	@AfterReturning(pointcut="log()",returning="obj")
	public void doAfterReturing(Object obj) {
		System.out.println("=========方法调用返回结果集以后===========");
	}
	
	@AfterThrowing(pointcut= "log()",throwing="e")
	public void doAfterThrowing(Throwable e) {
		e.printStackTrace();
		System.out.println("=========方法执行抛出异常===========");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
