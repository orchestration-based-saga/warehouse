package com.saga.warehouse.application.service;

import com.saga.warehouse.application.controller.api.PackageRequest;
import com.saga.warehouse.application.mappers.PackageMapper;
import com.saga.warehouse.domain.in.WarehouseDomainServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseService {
    private final WarehouseDomainServiceApi warehouseDomainServiceApi;
    private final PackageMapper mapper;

    public void savePackage(PackageRequest packageRequest) {
        warehouseDomainServiceApi.savePackage(mapper.toDomain(packageRequest));
    }
}
