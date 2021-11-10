package com.pravin.formbasedsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Override
	// Authentication Manager
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();// what type of security we want to use formbased, basic etc.
		// antMatchers("/sayHello") => all the incoming request will be allowed with URl "/sayHello"
		http.authorizeRequests().antMatchers("/sayHello").authenticated(); // permitAll()=> all the incoming requests will be allowed
		http.addFilterBefore(new MyCustomSecurityFilter(),BasicAuthenticationFilter.class);//Giving filter class name					
		
	}

	// If we define BCryptPasswordEncoder, then
	// AuthenticationManagerBuilder will automatically look for bean and use
	// BCryptPasswordEncoder
	// Using password encoder is mandatory
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
