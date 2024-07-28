package com.saga.warehouse.domain.out;

import com.saga.warehouse.domain.model.Package;

import java.util.List;

public interface WarehouseRepositoryApi {

    void savePackage(Package pack);

    List<Package> findByPackageIdIn(List<String> packageIds);

    void deliverPackages(List<String> packageIds);
}
