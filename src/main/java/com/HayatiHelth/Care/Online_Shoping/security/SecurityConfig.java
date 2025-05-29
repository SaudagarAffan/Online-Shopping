//package com.HayatiHelth.Care.Online_Shoping.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig 
//{
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
//	{
//		http
//		.csrf().disable() 
//		.authorizeRequests()
//		.requestMatchers("/login", "/registration").permitAll() 
//		.anyRequest().authenticated() 
//		
//		.and()
//		.formLogin().disable();
//		return http.build();
////		.formLogin()
////		.loginPage("/login")
////		.defaultSuccessUrl("/dashboard" , true)
////		.permitAll()
////		
////		.and()
////		
////		.logout()
////		.logoutSuccessUrl("/login?logout")
////		.permitAll();
//	
//	}
//}