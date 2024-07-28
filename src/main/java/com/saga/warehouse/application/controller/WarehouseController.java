package com.saga.warehouse.application.controller;

import com.saga.warehouse.application.controller.api.request.PackageIdsRequest;
import com.saga.warehouse.application.controller.api.request.PackageRequest;
import com.saga.warehouse.application.controller.api.response.WarehouseItemResponse;
import com.saga.warehouse.application.service.WarehouseService;
import com.saga.warehouse.domain.model.DeliveredPackage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<WarehouseItemResponse>> getAllItems(@RequestBody PackageIdsRequest packageIds) {
        List<WarehouseItemResponse> merchantInventories = warehouseService.getAllItems(packageIds);
        return ResponseEntity.ok().body(merchantInventories);
    }

    @PostMapping("/trigger-engine")
    public ResponseEntity<List<DeliveredPackage>> triggerEngine(@RequestBody PackageIdsRequest packageIds) {
        List<DeliveredPackage> response = warehouseService.triggerEngine(packageIds.packageIds());
        return ResponseEntity.ok().body(response);
    }

}
