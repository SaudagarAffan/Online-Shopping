package com.HayatiHelth.Care.Online_Shoping.filter;

import java.io.IOException; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.service.LoginServiceIMPL;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter implements Filter 
{
	@Autowired
	private LoginServiceIMPL loginServiceIMPL;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String path = httpRequest.getRequestURI();
		System.out.println(path);
		if (path.equals("/login") || path.equals("/registration") || path.equals("/loginPage")
				|| path.equals("/registrationPage") || path.equals("/dashboard") || path.equals("/product")
				|| path.equals("/products") || path.equals("/product/{productID}")) 
		{
			chain.doFilter(request, response);
			return;
		}

		String token = httpRequest.getHeader("Authorization");
		if (token == null || !isValidToken (token ,   request)) 
		{
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		chain.doFilter(request, response);
	}

	private boolean isValidToken(String token , ServletRequest request) 
	{
		String email = ((HttpServletRequest) request).getHeader("emailId");
		LoginUser user = loginServiceIMPL.getUserByEmail(email);
		return user.getAuthToken().equals(token);
	}
}
