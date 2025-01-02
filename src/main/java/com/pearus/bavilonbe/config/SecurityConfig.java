package com.pearus.bavilonbe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;
import org.springframework.web.accept.ContentNegotiationManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    CustomJwtDecoder customJwtDecoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        MediaTypeRequestMatcher mediaTypeRequestMatcher = new MediaTypeRequestMatcher(
                new ContentNegotiationManager(),
                MediaType.APPLICATION_JSON,
                MediaType.TEXT_HTML,
                MediaType.IMAGE_JPEG,
                MediaType.IMAGE_PNG
        );

        mediaTypeRequestMatcher.setUseEquals(false);

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> {
                    authorize
                            .requestMatchers(
                                    "/oauth2/verify",
                                    "/error", "/",
                                    "/api/auth/login",
                                    "/api/admin/account/send-mail",
                                    "/api/regis",
                                    "/api/public/**"
                            ).permitAll()
                            .requestMatchers(mediaTypeRequestMatcher)
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .oauth2Login(oauth2Login -> oauth2Login.loginPage("http://localhost:3000/sign-in")
                        .defaultSuccessUrl("http://localhost:3000/", true)
                        .failureUrl("http://localhost:3000/sign-in?error=true"))
                .logout(logout -> logout
                        .logoutSuccessUrl("http://localhost:3000/sign-in")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"));
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(customJwtDecoder)
                .jwtAuthenticationConverter(jwtAuthenticationConverter())));
        return http.build();
    }

    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");
        //jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("scope");
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return converter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }



}