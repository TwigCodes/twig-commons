package com.twigcodes.commons.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * SecurityConfig
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers(
            "/",
            "/login",
            "/index.html",
            "/v2/api-docs",
            "/actuator/**",
            "/webjars/**",
            "/h2-console/**",
            "/swagger-ui.html**",
            "/swagger-resources/**").permitAll()
        .anyRequest().authenticated();
  }
}
