package com.HayatiHelth.Care.Online_Shoping.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig 
{
	@Bean
	public FilterRegistrationBean<AuthenticationFilter> authenticationFilter()
	{

		FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new AuthenticationFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
}
