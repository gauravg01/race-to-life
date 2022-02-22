package com.racetolife.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource1){
		dataSource1 = this.dataSource;
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled"
	            + " from users where username=?")
	        .authoritiesByUsernameQuery("select username, authority "
	            + "from authorities where username=?");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**","/css/**","/images/**","/webfonts/**");
	}

	@Override    
	protected void configure(HttpSecurity http) throws Exception {    

		http.authorizeRequests().  
		antMatchers("/login","/register","/forget-password","/activateAccount").permitAll()  
		.antMatchers("/").hasAnyRole("USER","ADMIN")
		.antMatchers("/welcome").hasAnyRole("USER","ADMIN")
		.antMatchers("/logout").hasAnyRole("USER","ADMIN")
		.antMatchers("/myProfile").hasAnyRole("USER","ADMIN")
		.antMatchers("/updateMyProfile").hasAnyRole("USER","ADMIN")
		.antMatchers("/changePassword").hasAnyRole("USER","ADMIN")
		.antMatchers("/changeEmail").hasAnyRole("USER","ADMIN").anyRequest()
		.authenticated()  
		.and()  
		.formLogin()  
		.loginPage("/login").failureUrl("/login?error")
		.usernameParameter("username").passwordParameter("password")
		.permitAll()
		.and()  
		.logout()  
		.logoutRequestMatcher(new AntPathRequestMatcher("/login?logout"));
		http.csrf().disable();
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
}
