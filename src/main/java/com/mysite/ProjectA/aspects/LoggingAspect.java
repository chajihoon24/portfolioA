package com.mysite.ProjectA.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.ui.Model;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspect {
	
	@Value("${server.servlet.context-path}")
	private String contextPath;
	
	
	@Around("execution(String com.mysite.ProjectA.MainController.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed(); // 실제 메서드 실행

        // 모델 추가 로직은 여기에서 처리해야 함
        if (joinPoint.getArgs().length > 0 && joinPoint.getArgs()[0] instanceof Model) {
            Model model = (Model) joinPoint.getArgs()[0];
            model.addAttribute("contextPath", contextPath);
        }

        return result; // 원래의 리턴값 반환
    }
}
