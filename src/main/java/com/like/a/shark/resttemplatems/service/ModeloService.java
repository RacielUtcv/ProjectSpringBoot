package com.like.a.shark.resttemplatems.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ModeloService {

    @Value("${python.service.url}")
    private String basePath;

    private final RestTemplate restTemplate;

    public ModeloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public String enviarDatosParaPrediccion(String datos) {
        // Convertir datos a formato JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(datos, headers);

        String url = basePath;
        return restTemplate.postForObject(url, request, String.class);
    }
}
