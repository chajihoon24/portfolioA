package com.mysite.ProjectA;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configurations implements WebMvcConfigurer {
	
	@Value("${file.path}")
	String uploadPath;
	
	
    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
    	
    	
    	
        // 클라이언트에서 접근할 경로 패턴을 지정
        registry.addResourceHandler("/uploads/**")
                // 실제 파일 시스템 경로를 지정 (Windows 경로)
                .addResourceLocations(uploadPath);
    }
}