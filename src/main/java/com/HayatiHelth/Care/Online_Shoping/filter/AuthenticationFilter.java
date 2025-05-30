package com.HayatiHelth.Care.Online_Shoping.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String path = httpRequest.getRequestURI();
		if (path.equals("/login") || path.equals("/registration") || 
			    path.equals("/loginPage") || path.equals("/registrationPage")) {
			    chain.doFilter(request, response);
			    return;
			}


		String token = httpRequest.getHeader("Authorization");
		if (token == null || !isValidToken(token)) {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		chain.doFilter(request, response);
	}

	private boolean isValidToken(String token) {
		// Temporary logic: allow only token "ABC"
		return "ABC".equals(token);
	}
}
