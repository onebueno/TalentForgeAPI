package com.acme.fromzeroapi.shared.infraestructure.documentation.openapi.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI talentForgeApiOpenApi() {
        // General configuration
        var openAPI = new OpenAPI();
        openAPI.info(new Info()
                        .title("Talent Forge Web Application API")
                        .description("Talent Forge Web Application API documentation.")
                        .version("v1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Talent Forge Api wiki Documentation")
                        .url("https://talent-forge-api.wiki.github.io/docs"));
        return openAPI;
    }
}
