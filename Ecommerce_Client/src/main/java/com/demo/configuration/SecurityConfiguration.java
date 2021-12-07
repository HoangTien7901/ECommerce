package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.services.user.IUserService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private IUserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();

		http.authorizeRequests()
		.antMatchers("/manager/*/*").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/user/*").permitAll()
		.and()
		.formLogin().loginPage("/user/account/login")
		.loginProcessingUrl("/user/account/process-login")
		.defaultSuccessUrl("/user/home/index")
		.failureUrl("/user/account/login?error")
		.and()
		.exceptionHandling().accessDeniedPage("/user/account/accessDenied")
		.and()
		.logout().logoutUrl("/user/account/logout")
		.logoutSuccessUrl("/user/home/index?logout");
	}
	
	@Autowired
	public void configurateGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userService);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
