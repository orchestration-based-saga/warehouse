package com.saga.warehouse.infra.repository.jpa;

import com.saga.warehouse.infra.model.WarehouseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseItemEntityRepository extends JpaRepository<WarehouseItemEntity, Integer> {

    List<WarehouseItemEntity> findByPackageIdIn(List<String> packageIds);

}

