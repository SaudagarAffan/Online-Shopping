package com.HayatiHelth.Care.Online_Shoping.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig 
{
	@Autowired
    private AuthenticationFilter authenticationFilter;

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> loggingFilter(){
        FilterRegistrationBean<AuthenticationFilter> registrationBean 
          = new FilterRegistrationBean<>();

        registrationBean.setFilter(authenticationFilter);
        registrationBean.addUrlPatterns("/*");

        return registrationBean;    
    }
}
