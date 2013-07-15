package com.salil.futureapp.base.aspect;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common Aspect class #ASPECT
 * @author salil
 */
@Aspect
public class CustomLoggingAspect {
	
	protected static Logger logger = LoggerFactory.getLogger(CustomLoggingAspect.class);
	
	/**
	 * Returns current date time including milliseconds
	 * @return
	 */
	private String getCurrentDateTime()
	{
		Calendar now = Calendar.getInstance();
		return ((now.get(Calendar.MONTH) + 1)
		+ "-"
		+ now.get(Calendar.DATE)
		+ "-"
		+ now.get(Calendar.YEAR)
		+ " "
		+ now.get(Calendar.HOUR_OF_DAY)
		+ ":"
		+ now.get(Calendar.MINUTE)
		+ ":"
		+ now.get(Calendar.SECOND)
		+ "."
		+ now.get(Calendar.MILLISECOND)
		); 
	}
	
    @Pointcut("within(com.salil.futureapp.service..*)")
    public void my_service() {}
	
	 @Around("my_service()")
     public Object profileMethods(ProceedingJoinPoint pjp) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		String className = pjp.getTarget().getClass().toString();
		String methodName = pjp.getSignature().getName();
		
		logger.info("### START - " + className + "." + methodName + " - START: " + getCurrentDateTime() + " ###");
		Object output = pjp.proceed();
		logger.info("### END - " + className + "." + methodName + " - END: " + getCurrentDateTime() + " ###");

		long elapsedTime = System.currentTimeMillis() - startTime;
		
		logger.info("### Execution Time - " + className + "." + methodName + " - " + elapsedTime + " milliseconds ###");
		return output;
     }	 
	 
	@AfterThrowing(pointcut = "within(com.salil.futureapp.service..*)", throwing = "ex")
	public void afterThrowing(Exception ex) {
		try {
			logger.info("### Exception occured: " + ex.getMessage());
		} catch (Throwable e) {
		}
	}
	
}
