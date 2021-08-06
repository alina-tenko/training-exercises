package ua.training.kondratenko.cargodelivery.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/cargo").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/user")
                .permitAll()
                .and()
                .logout()
                .clearAuthentication(true)
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        final UserDetails admin = User
                .builder()
                .passwordEncoder(encoder::encode)
                .username("admin")
                .password("123")
                .accountExpired(false)
                .accountLocked(false)
                .roles("ADMIN")
                .build();
        final UserDetails user = User
                .builder()
                .passwordEncoder(encoder::encode)
                .username("user")
                .password("123")
                .accountExpired(false)
                .accountLocked(false)
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}