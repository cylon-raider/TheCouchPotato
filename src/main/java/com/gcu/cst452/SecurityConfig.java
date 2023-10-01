package com.gcu.cst452;

// Importing necessary libraries for Spring Security and other components
import com.gcu.cst452.business.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for security settings of the application.
 * <p>
 * This class extends WebSecurityConfigurerAdapter to provide security configurations.
 * It defines the security constraints and rules for the application.
 *
 * @author Chris Markel
 * @version 1.0
 */
@Configuration // Annotation to indicate that this is a configuration class
@EnableWebSecurity // Annotation to enable Spring Security's web security support
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Autowired's annotations for dependency injection
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserBusinessService service;

    /**
     * Bean for BCryptPasswordEncoder to encode passwords.
     *
     * @return a new instance of BCryptPasswordEncoder
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configuration for HTTP security.
     *
     * @param http an HttpSecurity object to modify
     * @throws Exception if an error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disabling CSRF protection
                .authorizeRequests()
                .antMatchers("/service/**").authenticated() // Securing /service/** URLs
                .and()
                .authorizeRequests()
                .antMatchers("/", "/registration/**", "/images/**", "/login").permitAll() // Permitting access to these URLs
                .anyRequest().authenticated() // Any other request needs authentication
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin") // URL for login processing
                .loginPage("/login") // Login page URL
                .failureUrl("/login?error") // URL for login failure
                .usernameParameter("username") // Username parameter name
                .passwordParameter("password") // Password parameter name
                .permitAll()
                .defaultSuccessUrl("/index", true) // Default URL after successful login
                .and()
                .httpBasic()
                .and()
                .logout()
                .logoutUrl("/logout") // URL for logout
                .invalidateHttpSession(true) // Invalidate session on logout
                .clearAuthentication(true) // Clear authentication on logout
                .permitAll()
                .logoutSuccessUrl("/"); // URL after successful logout
    }

    /**
     * Configuration for authentication manager builder.
     *
     * @param auth an AuthenticationManagerBuilder object to modify
     * @throws Exception if an error occurs
     */
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
    }
}
