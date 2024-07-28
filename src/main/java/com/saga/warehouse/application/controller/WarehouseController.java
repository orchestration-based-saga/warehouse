package com.saga.warehouse.application.controller;

import com.saga.warehouse.application.controller.api.PackageRequest;
import com.saga.warehouse.application.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/warehouse-management-system")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<Void> incomingDelivery(@RequestBody PackageRequest pack) {
        warehouseService.savePackage(pack);
        return ResponseEntity.ok().build();
    }

}
