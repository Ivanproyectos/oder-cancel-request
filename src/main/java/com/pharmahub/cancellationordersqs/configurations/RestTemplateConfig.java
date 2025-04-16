package com.pharmahub.cancellationordersqs.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        // Puedes ajustar los timeouts según tus necesidades
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // tiempo máximo para conectar (ms)
        factory.setReadTimeout(10000);   // tiempo máximo para leer respuesta (ms)

        return new RestTemplate(factory);
    }
}
