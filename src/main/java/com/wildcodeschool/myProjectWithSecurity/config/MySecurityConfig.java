package com.wildcodeschool.myProjectWithSecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	
		@Override
		public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();  
        http.authorizeRequests().antMatchers("/avengers/assemble").hasRole("CHAMPION")
        .and().formLogin().and().httpBasic();
        http.authorizeRequests().antMatchers("/secret-bases").hasRole("DIRECTOR")
        .and().formLogin().and().httpBasic();
		}

  
		@Autowired
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    
	    
	    auth
	    	.inMemoryAuthentication()
	    	
	        
	        .withUser("Steve")
	        .password(encoder.encode("motdepasse"))
	        .roles("CHAMPION")
	        .and()
	        .withUser("Nick")
	        .password(encoder.encode("flerken"))
	        .roles("DIRECTOR");
	    
	   
	}
		
}
