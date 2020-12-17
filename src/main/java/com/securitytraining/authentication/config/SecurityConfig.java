package com.securitytraining.authentication.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http
		.requiresChannel()
		.anyRequest()
		.requiresSecure()
		.and()
		.authorizeRequests()
		.anyRequest()
		.hasAnyRole("ADMIN","USER")
		.and()
		.httpBasic();
		
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}admin@training")
		.roles("ADMIN") // Role of the user
		.and()
		.withUser("user")
		.password("{noop}user@training")
		.credentialsExpired(true)
		.accountExpired(true)
		.accountLocked(true)
		.roles("USER"); // Role of the user
		
		
	}
	


}
