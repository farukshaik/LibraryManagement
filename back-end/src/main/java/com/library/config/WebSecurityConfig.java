package com.library.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.library.security.TraceablesLoginFailurehandler;
import com.library.security.TraceablesLoginSuccesshandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("prospectUserDetailsService2")
	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		CsrfTokenResponseHeaderBindingFilter csrfTokenFilter = new CsrfTokenResponseHeaderBindingFilter();
//		http.addFilterAfter(csrfTokenFilter, CsrfFilter.class);
		http.headers().frameOptions().disable();

		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/resources/public/**").permitAll()
				.antMatchers("/resources/img/**").permitAll().antMatchers("/resources/css/**").permitAll()
				.antMatchers("/resources/fonts/**").permitAll().antMatchers("/resources/bower_components/**")
				.permitAll().antMatchers(HttpMethod.GET, "/getBookDetailsByName").permitAll()
				.antMatchers(HttpMethod.POST, "/addStudent").permitAll()
				.antMatchers(HttpMethod.GET,"/getStudentData").permitAll()
				.antMatchers(HttpMethod.POST,"/issueBook").permitAll()
				.antMatchers(HttpMethod.POST,"/updateRank").permitAll()
				.antMatchers(HttpMethod.GET,"/getBooks").permitAll()
				.antMatchers(HttpMethod.GET,"/renewBook").permitAll()
				.antMatchers(HttpMethod.GET,"/libRenewBook").permitAll()
				.antMatchers(HttpMethod.GET,"/libSubmitBook").permitAll()
				.antMatchers(HttpMethod.POST,"/updateRank").permitAll()
		
				

				.anyRequest().authenticated().and().formLogin().loginPage("/resources/public/traceables-login.html")
				.loginProcessingUrl("/authenticate").successHandler(new TraceablesLoginSuccesshandler())
				.failureHandler(new TraceablesLoginFailurehandler()).permitAll().and().httpBasic().and().logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/resources/public/traceables-login.html").permitAll();

	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	

}
