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
	            + " from ase.users where username=?")
	        .authoritiesByUsernameQuery("select username, authority "
	            + "from ase.authorities where username=?");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**","/css/**","/images/**","/fonts/**","/icon/**","/js/**","/**/favicon.*");
	}

	@Override    
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().  
		antMatchers("/login","/register","/activateAccount","/loginWeb","/registerWeb","/reset-password-web","/error","/home","/","/activateAccountWeb","/subscribeWeb","/contactFormWeb").permitAll()  
		.antMatchers("/logout").hasAnyRole("USER","ADMIN")
		.antMatchers("/logoutWeb").hasAnyRole("USER","ADMIN")
		.antMatchers("/myProfile").hasAnyRole("USER","ADMIN")
		.antMatchers("/changePassword").hasAnyRole("USER","ADMIN")
		.antMatchers("/changeEmail").hasAnyRole("USER","ADMIN").anyRequest()
		.authenticated()  
		.and()  
		.formLogin()  
		.loginPage("/loginWeb").failureUrl("/loginWeb?error")
		.usernameParameter("username").passwordParameter("password")
		.permitAll()
		.and()  
		.logout()  
		.logoutRequestMatcher(new AntPathRequestMatcher("/loginWeb?logout"));
		http.csrf().disable();
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
}
