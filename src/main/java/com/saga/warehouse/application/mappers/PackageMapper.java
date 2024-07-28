package com.saga.warehouse.application.mappers;

import com.saga.warehouse.application.controller.api.request.PackageRequest;
import com.saga.warehouse.application.controller.api.response.WarehouseItemResponse;
import com.saga.warehouse.application.controller.api.enums.WarehouseItemStatus;
import com.saga.warehouse.domain.model.Package;
import com.saga.warehouse.domain.model.enums.ItemStatusDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PackageMapper {

    @Mapping(target = "courierName", source = "courier")
    @Mapping(target = "status", ignore = true)
    Package toDomain(PackageRequest request);

    WarehouseItemStatus toResponse(ItemStatusDomain statusDomain);

    WarehouseItemResponse toResponse(Package pack);

    List<WarehouseItemResponse> toResponse(List<Package> pack);
}
