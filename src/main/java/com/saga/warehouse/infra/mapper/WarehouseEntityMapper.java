package com.saga.warehouse.infra.mapper;

import com.saga.warehouse.domain.model.Package;
import com.saga.warehouse.infra.model.MerchantProductEntity;
import com.saga.warehouse.infra.model.WarehouseItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface WarehouseEntityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", source = "merchantInventoryId", qualifiedByName = "linkProduct")
    WarehouseItemEntity toEntity(Package pack);

    @Named("linkProduct")
    default MerchantProductEntity linkProduct(Integer merchantInventoryId) {
        return MerchantProductEntity.builder()
                .merchantInventoryId(merchantInventoryId)
                .build();
    }

    @Mapping(target = "merchantInventoryId", source = "warehouseItemEntity.product.merchantInventoryId")
    Package toDomain(WarehouseItemEntity warehouseItemEntity);

    List<Package> toDomain(List<WarehouseItemEntity> warehouseItemEntities);
}
