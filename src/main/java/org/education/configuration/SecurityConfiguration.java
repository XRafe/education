package org.education.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final ConfigurationFilter configurationFilter;

    private static final String[] WHITE_LIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    @Bean
    public DefaultSecurityFilterChain configurationHttpFilter(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers(WHITE_LIST)
                .permitAll();

        http
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .authorizeHttpRequests().requestMatchers("/user/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(configurationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
