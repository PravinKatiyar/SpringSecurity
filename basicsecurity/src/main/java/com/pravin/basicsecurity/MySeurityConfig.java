package com.pravin.basicsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySeurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationProvider authenticationProvider;
//	@Override
//	// Authentication Manager
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// Creating Object of BCryptPasswordEncoder to encode the password later on
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		// Using InMemory userDetailsService
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		// Creating a user with user-name and
//		// password........................................Setting authorities grant
//		UserDetails user = User.withUsername("pravin").password(passwordEncoder.encode("abc")).authorities("read")
//				.build();
//		userDetailsService.createUser(user);
//		auth.userDetailsService(userDetailsService);
//	}
	
	@Override
	// Authentication Manager
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();// what type of security we want to use formbased,basic etc.
		// all the incoming request first need to be authenticated
		http.authorizeRequests().anyRequest().authenticated(); // permitAll()=> all the incoming requests will be
																// allowed
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
