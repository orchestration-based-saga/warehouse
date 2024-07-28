package com.saga.warehouse.application.service;

import com.saga.warehouse.application.controller.api.request.PackageIdsRequest;
import com.saga.warehouse.application.controller.api.request.PackageRequest;
import com.saga.warehouse.application.controller.api.response.WarehouseItemResponse;
import com.saga.warehouse.application.mappers.PackageMapper;
import com.saga.warehouse.domain.in.WarehouseDomainServiceApi;
import com.saga.warehouse.domain.model.DeliveredPackage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {
    private final WarehouseDomainServiceApi warehouseDomainServiceApi;
    private final PackageMapper mapper;

    public void savePackage(PackageRequest packageRequest) {
        warehouseDomainServiceApi.savePackage(mapper.toDomain(packageRequest));
    }

    public List<WarehouseItemResponse> getAllItems(PackageIdsRequest request) {
        return mapper.toResponse(warehouseDomainServiceApi.getAllItems(request.packageIds()));
    }

    public List<DeliveredPackage> triggerEngine(List<String> packageIds){
        return warehouseDomainServiceApi.deliverItemsToWarehouse(packageIds);
    }
}
