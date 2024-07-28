package com.saga.warehouse.infra.repository;

import com.saga.warehouse.domain.model.Package;
import com.saga.warehouse.domain.out.WarehouseRepositoryApi;
import com.saga.warehouse.infra.mapper.WarehouseEntityMapper;
import com.saga.warehouse.infra.repository.jpa.WarehouseItemEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WarehouseRepository implements WarehouseRepositoryApi {

    private final WarehouseItemEntityRepository warehouseItemEntityRepository;
    private final WarehouseEntityMapper mapper;

    @Override
    public void savePackage(Package pack) {
        warehouseItemEntityRepository.save(mapper.toEntity(pack));
    }
}
