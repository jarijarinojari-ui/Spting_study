package com.global.rest.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Value("${server.port:8080}")
    private String serverPort;
    
    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MUSIC REST API")
                        .description("""
                                <h3>MUSIC_JDBC > MUSIC_MVC > MUSIC_REST</h3>
                                """)
                        .version("v1.0.0")
                        .contact(new Contact().email("globaljavateacher@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub")
                        .url("https://github.com/globaljavateacher"))
                .servers(List.of(
                        new Server().url("http://localhost:" + serverPort + contextPath).description("로컬 개발 서버")
                ))
                .components(new Components());
    }
}
