package com.saga.warehouse.domain.service;

import com.saga.warehouse.domain.in.WarehouseDomainServiceApi;
import com.saga.warehouse.domain.model.DeliveredPackage;
import com.saga.warehouse.domain.model.Package;
import com.saga.warehouse.domain.out.WarehouseRepositoryApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Slf4j
public class WarehouseDomainService implements WarehouseDomainServiceApi {

    private final WarehouseRepositoryApi warehouseRepositoryApi;

    @Override
    public void savePackage(Package pack) {
        pack = warehouseRepositoryApi.savePackage(pack);
        deliverItemsToWarehouse(List.of(pack.packageId()));
    }

    @Override
    public List<Package> getAllItems(List<String> packageIds) {
        return warehouseRepositoryApi.findByPackageIdIn(packageIds);
    }

    @Override
    public List<DeliveredPackage> deliverItemsToWarehouse(List<String> packageIds) {
        List<String> deliveredPackageIds = new ArrayList<>();
        List<DeliveredPackage> deliveredItems = new ArrayList<>();
        packageIds.forEach(packageId -> {
            double value = ThreadLocalRandom.current().nextDouble();
            if (value > 0.5){
                deliveredItems.add(new DeliveredPackage(packageId, true));
                deliveredPackageIds.add(packageId);
                log.info("Package {} delivered", packageId);
            }
            else {
                deliveredItems.add(new DeliveredPackage(packageId, false));
            }
        });
        warehouseRepositoryApi.deliverPackages(deliveredPackageIds);
        return deliveredItems;
    }
}
