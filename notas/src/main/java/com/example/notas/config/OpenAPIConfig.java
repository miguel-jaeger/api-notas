package com.example.notas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Notas")
                        .version("1.0.0")
                        .description("Documentación completa de la API")
                        .contact(new Contact()
                                .name("Miguel Jaeger")
                                .email("miguel.jaeger@example.com")));
    }
}
