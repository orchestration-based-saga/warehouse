package com.saga.warehouse.domain.service;

import com.saga.warehouse.domain.in.WarehouseDomainServiceApi;
import com.saga.warehouse.domain.model.Package;
import com.saga.warehouse.domain.out.WarehouseRepositoryApi;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WarehouseDomainService implements WarehouseDomainServiceApi {

    private final WarehouseRepositoryApi warehouseRepositoryApi;

    @Override
    public void savePackage(Package pack) {
        warehouseRepositoryApi.savePackage(pack);
    }

    @Override
    public List<Package> getAllItems(List<String> packageIds) {
        return warehouseRepositoryApi.findByPackageIdIn(packageIds);
    }
}
