package com.lesnoy.infopet.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class ConfigOpenAPI {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Doc")
                        .version("1.0.0")
                        .description("Spring doc")
                        .contact(
                                new Contact()
                                        .email("kilril2101@gmail.com")
                                        .name("Kirill Yadevich")
                        ));
    }


}
