package com.ejercicio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecutiryConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
		authentication
		.inMemoryAuthentication()
		.withUser("user1")
			.password("{noop}user1") 
			.roles(Roles.GUESS.name())
			.and()
		.withUser("user2")
			.password("{noop}user2") 
			.roles(Roles.OPERATOR.name())
			.and()
		.withUser("user3")
			.password("{noop}user3") 
			.roles(Roles.ADMIN.name())
			.and()
		.withUser("user4")
			.password("{noop}user4")
			.roles(Roles.OPERATOR.toString(), Roles.ADMIN.name());

	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/curso").hasRole(Roles.ADMIN.name())
		.antMatchers(HttpMethod.PUT, "/curso").hasAnyRole(Roles.ADMIN.name(), Roles.OPERATOR.name())
		.antMatchers(HttpMethod.DELETE, "/curso").hasAnyRole(Roles.ADMIN.name(), Roles.OPERATOR.name())
		.antMatchers(HttpMethod.GET, "/**").authenticated() 
		.and()
		.httpBasic();
	}
}
