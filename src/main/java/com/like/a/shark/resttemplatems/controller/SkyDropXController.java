package com.like.a.shark.resttemplatems.controller;

import com.like.a.shark.resttemplatems.service.SkyDropXService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class SkyDropXController {

    private final SkyDropXService skyDropXService;

    public SkyDropXController(SkyDropXService skyDropXService) {
        this.skyDropXService = skyDropXService;
    }

    // Solo peticiones GET
    @GetMapping("/skydropx-shipments")
    public String getSkyDropXShipments() {
        return skyDropXService.obtenerEnviosDeSkyDropX();
    }

    @GetMapping("/skydropx-labels")
    public String getLabels() {
        return skyDropXService.obtenerEtiquetas();
    }

    @GetMapping("/skydropx-carriers")
    public String getcarriers() {
        return skyDropXService.obtenerCarriers();
    }

    @GetMapping("/skydropx-cancel_label_requests")
    public String getCancel_label_requests() {
        return skyDropXService.getCancel_label_requests();
    }

    @GetMapping("/skydropx-bulk_labels")
    public String getBulk_labels() {
        return skyDropXService.getBulk_labels();
    }

    @GetMapping("/skydropx-consignment_notes/categories")
    public String getCategories() {
        return skyDropXService.getCategories();
    }

    @GetMapping("/skydropx-consignment_notes/categories/CATEGORY_ID/subcategories")
    public String getSubCategories() {
        return skyDropXService.getSubCategories();
    }
    
    @GetMapping("/skydropx-consignment_notes/subcategories/SUBCATEGORY_ID/classes")
    public String getSubClasses() {
        return skyDropXService.getSubClasses();
    }
    
    @GetMapping("/skydropx-consignment_notes/packagings")
    public String getCartasPoder() {
        return skyDropXService.getCartasPoder();
    }

    // solo peticiones POST
    @PostMapping("/skydropx-shipments")
    public String postSkyDropXShipment(@RequestBody String shipmentRequest) {
        return skyDropXService.publicarEnvioEnSkyDropX(shipmentRequest);
    }

    @PostMapping("/skydropx-quotations")
    public String postSkyDropXQuotations(@RequestBody String quotationRequest) {
        return skyDropXService.enviarCotizacionASkyDropX(quotationRequest);
    }

    @PostMapping("/skydropx-labels")
    public String createLabel(@RequestBody String labelRequest) {
        return skyDropXService.createLabel(labelRequest);
    }
}
