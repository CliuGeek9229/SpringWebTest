package web2017.team8.liucong.annotation;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
//import org.slf4j.Logger;  
//import org.slf4j.LoggerFactory; 
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import web2017.team8.liucong.dao.SystLogDao;
import web2017.team8.liucong.domain.SystemLog;
import web2017.team8.liucong.domain.User;
import web2017.team8.liucong.service.SystemLogService;

/**
 *
 * @ClassName SystemLogAspect.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年11月14日 上午10:11:06 
 * @Description 切面处理类 
 */
@Aspect
@Component

public class SystemLogAspect {
	@Autowired
	private SystemLogService systemLogService;
	@Autowired
	private HttpServletRequest request;
//	private SystemLog systemLog;
	@After(value="execution(* web2017.team8.liucong.dao.LoginLDao.*(..))")
	public void BeforeMethod(JoinPoint jp){
		//2017-12-14
//		HttpServletRequest request = getRequestArg(jp.getArgs());
//		joinPoint是org.aspectj.lang.JoinPoint类型的
		
		
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("【前置增强】【dao层日志】："+methodName+"方法执行！【该方法的参数为：】"+Arrays.asList(args));
		SystemLog systemLog = new SystemLog();
		systemLog.setDate(new Date());
		systemLog.setOperationName(methodName);
		systemLog.setOperationModel(jp.getSignature().getDeclaringTypeName());
		systemLog.setIp(request.getLocalAddr());
		System.out.println(systemLog.getIp());
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user.toString());
		systemLog.setCreateBy(user.getUsername());
		//User user = (User) request.getSession().getAttribute("user");
		//String name = user.getUsername();
		//systemLog.setCreateBy(name);
		systemLogService.insertSystemLogInfo(systemLog);
	}
	//2017-12-14  这个方法可以解决springAOP中获取httpservletrequest的问题
	//但是问题就是，每个被增强的方法都得有一个httpservletrequest方法
	//
//	public HttpServletRequest getRequestArg(Object[] args) {
//	    if (null == args || args.length == 0) {
//	            throw new IllegalArgumentException("方法缺少HttpServletRequest参数");
//	    }
//	    for (Object o : args) {
//	        if (o instanceof HttpServletRequest) {
//	            return (HttpServletRequest)o;
//	        }
//	    }
//	    throw new IllegalArgumentException("方法缺少HttpServletRequest参数");
//	}
//	
	
	
//	@AfterReturning(value="execution(* web2017.team8.liucong.dao.*.*(..))")
//	public void AfterReturnMethod(JoinPoint jp) {
//		String methodName = jp.getSignature().getName();
//		System.out.println("【后置增强】【dao层日志】："+methodName+"方法结束！！！！！");
//	}
//	@Around(value="execution(* web2017.team8.liucong.service.*.*(..))")
//	public Object AroundMethod(ProceedingJoinPoint pjp) {
//		String methodName = pjp.getSignature().getName();
//		Object[] args = pjp.getArgs();
//		Object result = null;
//		try {
//			System.out.println("【环绕增强  qian】【service层日志】："+methodName+"方法执行！【该方法参数为：】"+Arrays.asList(args));
//			result = pjp.proceed();
//			
//		}catch(Throwable e){
//			e.printStackTrace();
//		}finally {
//			System.out.println("【环绕增强  hou】【service层日志】："+methodName+"方法结束!!!!");
//		}
//		return result;
//	}
//	@Around(value="execution(* web2017.team8.liucong.controller.*.*(..))")
//	public Object AroundMethod2(ProceedingJoinPoint pjp) {
//		String methodName = pjp.getSignature().getName();
//		Object[] args = pjp.getArgs();
//		Object result = null;
//		try {
//			System.out.println("【环绕增强 qian】【controller层日志】："+methodName+"方法执行！【方法拥有参数为：】"+Arrays.asList(args));
//			result = pjp.proceed();
//		}catch(Throwable e){
//			e.printStackTrace();
//		}finally {
//			System.out.println("【环绕增强  hou】【controller层日志】："+methodName+"方法结束！！！【方法返回值为：】"+result);
//		}
//		return result;
//	}
	
}
