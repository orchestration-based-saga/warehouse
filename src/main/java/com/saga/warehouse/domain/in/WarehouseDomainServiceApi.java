package com.saga.warehouse.domain.in;

import com.saga.warehouse.domain.model.DeliveredPackage;
import com.saga.warehouse.domain.model.Package;

import java.util.List;

public interface WarehouseDomainServiceApi {

    void savePackage(Package pack);

    List<Package> getAllItems(List<String> packageIds);

    List<DeliveredPackage> deliverItemsToWarehouse(List<String> packageIds);
}
