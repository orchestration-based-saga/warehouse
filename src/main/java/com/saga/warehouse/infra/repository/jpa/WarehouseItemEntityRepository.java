package com.saga.warehouse.infra.repository.jpa;

import com.saga.warehouse.infra.model.WarehouseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseItemEntityRepository extends JpaRepository<WarehouseItemEntity, Integer> {
}
