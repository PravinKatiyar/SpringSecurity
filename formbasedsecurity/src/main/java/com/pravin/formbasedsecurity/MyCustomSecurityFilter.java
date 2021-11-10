package com.pravin.formbasedsecurity;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyCustomSecurityFilter implements Filter {
	//public class MyCustomSecurityFilter extends GenericFilterBean { 
	//public class MyCustomSecurityFilter implements OncePerRequestFilter { =>If we want to filter logic to be executed once


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// what ever the logic we will write below will be executed on "request" before
		// it will be passed to next stage
		System.out.println("Before");
		chain.doFilter(request, response);
		// what ever the logic we will write below will be executed on "response" .
		System.out.println("After");

	}

}
