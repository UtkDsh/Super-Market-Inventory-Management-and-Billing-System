package com.supermarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

	
	@Bean
	public WebMvcConfigurer corsconfigurer()
	{
		return new WebMvcConfigurer() {
			
			public void addCorsMapping(CorsRegistry registry)
			{
				registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000/")
				.allowedMethods("GET","POST","PUT","OPTIONS","DELETE")
				.allowedHeaders("*")
				.allowCredentials(true);
			}
			
			
		};
	}
}
