package com.project.Farmobile.config;

import com.project.Farmobile.users.data.help.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.project.Farmobile.config.JwtTokenFilter;
import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenFilter jwtTokenFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                        }
                )
                .and();
        // Set permissions on endpoints
        http.authorizeRequests()
                .mvcMatchers("/user/my-info").authenticated()
                .mvcMatchers("/orders/get-all").hasAnyRole(String.valueOf(Roles.ADMIN))
                .mvcMatchers("/user/all").hasAnyRole(String.valueOf(Roles.ADMIN))
                .mvcMatchers("/photo/upload").hasAnyRole(String.valueOf(Roles.ADMIN))
                .mvcMatchers("/category/get").hasAnyRole(String.valueOf(Roles.ADMIN))
                .mvcMatchers("/products/create").hasAnyRole(String.valueOf(Roles.ADMIN))
                .mvcMatchers("/orders/id").hasAnyRole(String.valueOf(Roles.ADMIN))
                .anyRequest().permitAll();
        // Add JWT token filter
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}