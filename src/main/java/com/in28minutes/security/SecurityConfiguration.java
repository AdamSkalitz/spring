package com.in28minutes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("An Author").password("pass")
				.roles("USER", "ADMIN");
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/login").permitAll()
//				.antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
//				.formLogin();
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.antMatchers("/login").permitAll()
					.antMatchers("/*book*/**").permitAll()
					.antMatchers("/*todo*/**").permitAll()
					.antMatchers("/").access("hasRole('USER')").and()
					.formLogin();
//		http.authorizeRequests().antMatchers("/login").permitAll()
//		.antMatchers("/", "/*todo*/**", "/*book*/**").access("hasRole('USER')").and()
//		.formLogin();
	}
}