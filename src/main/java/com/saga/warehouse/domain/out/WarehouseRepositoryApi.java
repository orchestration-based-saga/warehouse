package com.saga.warehouse.domain.out;

import com.saga.warehouse.domain.model.Package;

public interface WarehouseRepositoryApi {

    void savePackage(Package pack);
}
