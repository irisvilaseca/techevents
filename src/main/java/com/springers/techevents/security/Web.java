package com.springers.techevents.security;

import com.springers.techevents.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class Web extends WebSecurityConfigurerAdapter
{
    private AccessDenied denied;

    private UserServiceImpl users;

    public Web(AccessDenied denied, UserServiceImpl users)
    {
        this.denied = denied;
        this.users = users;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(users).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable().authorizeRequests().antMatchers("/event/**").hasRole("ADMIN").antMatchers("/CSS/**", "/JS/**", "/img/**", "/home", "/denied", "/register").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll().and().logout().logoutSuccessUrl("/login").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll().and().exceptionHandling().accessDeniedHandler(denied);
    }
}