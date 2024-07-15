package com.boardgame.webstorage.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers("/user/new",
                        "/user/authenticate",
                        "/boardgame/allrows",
                        "/user/find/{\\\\d+}",
                        "/", "./")
                .permitAll()
                .antMatchers("/resources/**", "/static/**", "/resources/static/css/**", "/resources/static/font/**", "/resources/static/img/**", "/resources/static/js/**", "/resources/static/**")
                .permitAll()
                .antMatchers("/resources/static/css/chunk-vendors.bf9bb939.css", "/css/chunk-vendors.bf9bb939.css", "/css/**")
                .permitAll()
                .antMatchers("/resources/static/js/app.1a2fed18.js", "/js/app.1a2fed18.js", "/js/**")
                .permitAll()
                .antMatchers("/img/**", "/fonts/**", "/myimage/**", "/game/img/**", "/game/img/brass.f861f0a8.png")
                .permitAll()
                .antMatchers("/static/img/**", "/static/fonts/**", "/myimage/**", "/static/js/**","/static/js/chunk-vendors.99ff3936.js", "/static/js/chunk-vendors.99ff3936.js", "/static/js/app.6dcdcdf0.js", "/static/css/**")
                .permitAll()
                .antMatchers("/favicon.ico")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/resources/static/css/**", "/resources/static/font/**", "/resources/static/img/**", "/resources/static/js/**", "/resources/static/**");
    }
}
