package com.saga.warehouse.infra.mapper;

import com.saga.warehouse.domain.model.Package;
import com.saga.warehouse.infra.model.WarehouseItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WarehouseEntityMapper {

    @Mapping(target = "id", ignore = true)
    WarehouseItemEntity toEntity(Package pack);
}
