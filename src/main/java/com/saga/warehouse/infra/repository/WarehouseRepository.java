package com.saga.warehouse.infra.repository;

import com.saga.warehouse.domain.model.Package;
import com.saga.warehouse.domain.out.WarehouseRepositoryApi;
import com.saga.warehouse.infra.mapper.WarehouseEntityMapper;
import com.saga.warehouse.infra.model.WarehouseItemEntity;
import com.saga.warehouse.infra.model.enums.ItemStatus;
import com.saga.warehouse.infra.repository.jpa.WarehouseItemEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WarehouseRepository implements WarehouseRepositoryApi {

    private final WarehouseItemEntityRepository warehouseItemEntityRepository;
    private final WarehouseEntityMapper mapper;

    @Override
    public Package savePackage(Package pack) {
        WarehouseItemEntity item = mapper.toEntity(pack);
        item.setStatus(ItemStatus.IN_DELIVERY);
        return mapper.toDomain(warehouseItemEntityRepository.save(item));
    }

    @Override
    public List<Package> findByPackageIdIn(List<String> packageIds) {
        return mapper.toDomain(warehouseItemEntityRepository.findByPackageIdIn(packageIds));
    }

    @Override
    public void deliverPackages(List<String> packageIds) {
        List<WarehouseItemEntity> items = warehouseItemEntityRepository.findByPackageIdIn(packageIds);
        items.forEach(item -> item.setStatus(ItemStatus.DELIVERED));
        warehouseItemEntityRepository.saveAll(items);
    }
}
