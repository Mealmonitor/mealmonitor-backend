package com.galitianu.mealmonitorbackend.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {
    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("https://keycloak.mealmonitor.galitianu.com")
                .realm("mealmonitor")

                .clientSecret("MJVSbisw5bK4oSykVlvjREMqTy7aUtxq")
                .clientId("mealmonitor-backend")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }


}
