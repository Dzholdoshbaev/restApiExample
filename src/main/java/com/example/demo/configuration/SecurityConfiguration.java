package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final DataSource dataSource;

    public SecurityConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        String fetchUsersQuery = "SELECT login AS username, password, enabled FROM users WHERE login = ?";

        String fetchAuthorityQuery =
                "SELECT u.login AS username, a.authority " +
                        "FROM users u " +
                        "JOIN authorities a ON u.authority_uuid = a.uuid " +
                        "WHERE u.login = ?";

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(fetchUsersQuery)
                .authoritiesByUsernameQuery(fetchAuthorityQuery);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST,"api/authors").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT,"api/authors").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"api/authors/*").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST,"api/books").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT,"api/books").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"api/books/*").hasAuthority("ADMIN")
                .anyRequest().permitAll());
        return http.build();
    }

}
