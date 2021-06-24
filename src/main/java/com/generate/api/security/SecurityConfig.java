package com.generate.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.generate.api.security.jwt.JwtAthorizationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private JwtAthorizationFilter jwtAuthorizationFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint)
			.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.antMatchers(HttpMethod.POST, "/auth/login").permitAll()
			.antMatchers(HttpMethod.POST, "/user/new").permitAll()
			.antMatchers(HttpMethod.GET, "/user/**").authenticated()
			.antMatchers(HttpMethod.PUT, "/user/update").authenticated()
			.antMatchers(HttpMethod.POST, "/post").authenticated()
			.antMatchers(HttpMethod.PUT, "/post").authenticated()
			.antMatchers(HttpMethod.GET, "/post").permitAll()
			.antMatchers(HttpMethod.GET, "/post/**").permitAll()
			.antMatchers(HttpMethod.POST, "/categoria").authenticated()
			.antMatchers(HttpMethod.PUT, "/categoria").authenticated()
			.antMatchers(HttpMethod.GET, "/categoria").permitAll()
			.anyRequest().authenticated();
		
		http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
		
		/*
		.antMatchers(HttpMethod.POST, "/auth/login").permitAll()
		.antMatchers(HttpMethod.GET, "/producto/**", "/lote/**").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/producto/**", "/lote/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/producto/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/producto/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/pedido/**").hasAnyRole("USER","ADMIN")
		.anyRequest().authenticated();*/
			
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	                @Override
	                public void addCorsMappings(CorsRegistry registry) {
	                        registry.addMapping("/**")
	                                .allowedOrigins("http://localhost:4200")
	                                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                                .maxAge(3600);
	                }

	        };
	}

	

	

}
