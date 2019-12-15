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
		public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/");
        	
		}

  
		@Autowired
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    
	    
	    auth
	    	.inMemoryAuthentication()
	    	
	        
	        .withUser("Steve")
	        .password(encoder.encode("CHAMPIONNickflerkenDIRECTOR"))
	        .roles("ADMIN")
	        .and()
	        .withUser("SHIELD")
	        .password(encoder.encode("password2"))
	        .roles("USER");
	    
	   
	}
		
}
