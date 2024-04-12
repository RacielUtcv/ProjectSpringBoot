package com.like.a.shark.resttemplatems.controller;

import com.like.a.shark.resttemplatems.service.ModeloService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping("/realizar-prediccion")
    public String realizarPrediccion(@RequestBody String datos) {
        // Llamar al servicio para enviar los datos al servicio Flask y obtener la respuesta
        return modeloService.enviarDatosParaPrediccion(datos);
    }
}
