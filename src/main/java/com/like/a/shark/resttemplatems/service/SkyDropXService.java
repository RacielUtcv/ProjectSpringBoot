package com.like.a.shark.resttemplatems.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SkyDropXService {
    @Value("${spring.external.service.base-url}")
    private String basePath;

    @Value("${skydropx.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;


    // Método para integrar la API de SkyDropX y obtener información sobre envíos
    @SuppressWarnings("null")
    public String obtenerEnviosDeSkyDropX() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String response = restTemplate.exchange(basePath + "/v1/shipments", HttpMethod.GET, entity, String.class).getBody();
        return response;
    }

    
    //optener las portadores
    @SuppressWarnings("null")
     public String obtenerCarriers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
    
        String response = restTemplate.exchange(basePath + "/v1/carriers", HttpMethod.GET, entity, String.class).getBody();
        return response;
    }

    //Crear un nuevo envio
    @SuppressWarnings("null")
    public String publicarEnvioEnSkyDropX(String shipmentRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(shipmentRequest, headers);

        return restTemplate.exchange(basePath + "/v1/shipments", HttpMethod.POST, entity, String.class).getBody();
    }

    //crear cotizacion
    @SuppressWarnings("null")
    public String enviarCotizacionASkyDropX(String quotationRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(quotationRequest, headers);

        return restTemplate.exchange(basePath + "/v1/quotations", HttpMethod.POST, entity, String.class).getBody();
    }

    //optener las etiquetas
    @SuppressWarnings("null")
    public String obtenerEtiquetas() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String response = restTemplate.exchange(basePath + "/v1/labels", HttpMethod.GET, entity, String.class).getBody();
        return response;
    }

    //crear una etiqueta
    @SuppressWarnings("null")
    public String createLabel(String labelData) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(labelData, headers);

        return restTemplate.exchange(basePath + "/v1/labels", HttpMethod.POST, entity, String.class).getBody();
    }

    //Obtener toda la solicitud de etiqueta de cancelación
    @SuppressWarnings("null")
    public String getCancel_label_requests() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        String response = restTemplate.exchange(basePath + "/v1/cancel_label_requests", HttpMethod.GET, entity, String.class).getBody();
        return response;
        }
    
    //Obtener Etiquetas a granel
    @SuppressWarnings("null")
    public String getBulk_labels() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
            
        String response = restTemplate.exchange(basePath + "/v1/bulk_labels", HttpMethod.GET, entity, String.class).getBody();
        return response;
        }

    //Obtener las cateegorias
    @SuppressWarnings("null")
    public String getCategories() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
            
        String response = restTemplate.exchange(basePath + "/v1/consignment_notes/categories", HttpMethod.GET, entity, String.class).getBody();
        return response;
        }

    //Obtener las sub-cateegorias
    @SuppressWarnings("null")
    public String getSubCategories() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
                
        String response = restTemplate.exchange(basePath + "/v1/consignment_notes/categories/CATEGORY_ID/subcategories", HttpMethod.GET, entity, String.class).getBody();
        return response;
        }

    //Obtener las sub-clases
    @SuppressWarnings("null")
    public String getSubClasses() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
                
        String response = restTemplate.exchange(basePath + "/v1/consignment_notes/subcategories/SUBCATEGORY_ID/classes", HttpMethod.GET, entity, String.class).getBody();
        return response;
        }

    //Obtener los embalajes de carta poder
    @SuppressWarnings("null")
    public String getCartasPoder() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
                
        String response = restTemplate.exchange(basePath + "/v1/consignment_notes/packagings", HttpMethod.GET, entity, String.class).getBody();
        return response;
        }


}


