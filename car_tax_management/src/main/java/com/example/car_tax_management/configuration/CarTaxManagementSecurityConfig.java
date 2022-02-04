package com.example.car_tax_management.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class CarTaxManagementSecurityConfig extends WebSecurityConfigurerAdapter {

    String jwkSetUri = "http://localhost:8090/auth/realms/VehicleTaxManagementRealm/protocol/openid-connect/certs";

    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter(){
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
        return jwtConverter;
    }

    @Bean
    JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/").permitAll()
                .antMatchers(HttpMethod.GET,"/v2/api-docs").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger-resources").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger-resources/**").permitAll()
                .antMatchers(HttpMethod.GET,"/v3/api-docs/**").permitAll()
                .antMatchers(HttpMethod.GET,"/configuration/ui").permitAll()
                .antMatchers(HttpMethod.GET,"/configuration/security").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger-ui.html").permitAll()
                .antMatchers(HttpMethod.GET,"/swagger-ui/*").permitAll()
                .antMatchers(HttpMethod.GET,"/webjars/**").permitAll()
                .antMatchers(HttpMethod.GET,"/ownerdetails/*").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.GET,"/taxdetails/*").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.GET,"/address/*").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.GET,"/sorn/*").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.GET,"/owner/*").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.GET,"/taxinfo/*").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.GET,"/taxpayment/*").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.GET,"/profile/*").hasRole("taxmanagementuser")
                .antMatchers(HttpMethod.POST,"/**").hasRole("taxmanagementadmin")
                .antMatchers(HttpMethod.PUT,"/**").hasRole("taxmanagementadmin")
                .antMatchers(HttpMethod.PATCH,"/**").hasRole("taxmanagementadmin")
                .antMatchers(HttpMethod.DELETE,"/**").hasRole("taxmanagementadmin")
                .anyRequest().authenticated().and().oauth2ResourceServer().jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()));


    }
}
