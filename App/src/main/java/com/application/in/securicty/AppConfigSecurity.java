package com.application.in.securicty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;



@EnableWebSecurity
public class AppConfigSecurity extends WebSecurityConfigurerAdapter {
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//
//		List<UserDetails> user = new ArrayList<UserDetails>();
//		user.add(User.withDefaultPasswordEncoder().username("channa").password("1234").roles("USER").build());
//
//		return new InMemoryUserDetailsManager(user);
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER").and().withUser("admin")
				.password("{noop}password").roles("USER", "ADMIN");

	}

	// Secure the endpoins with HTTP Basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		http
				// HTTP Basic authentication
				.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/home/test/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/home/reg/**").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/home/**").hasRole("USER")
				.antMatchers(HttpMethod.PATCH, "/home/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/home/**").hasRole("ADMIN")
				.and()	.csrf().disable().formLogin().disable() .authorizeRequests() .anyRequest().permitAll();
				
	}

}
