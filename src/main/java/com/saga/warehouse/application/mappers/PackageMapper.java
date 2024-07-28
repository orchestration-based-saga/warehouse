package com.saga.warehouse.application.mappers;

import com.saga.warehouse.application.controller.api.PackageRequest;
import com.saga.warehouse.domain.model.Package;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PackageMapper {

    @Mapping(target = "courierName", source = "courier")
    Package toDomain(PackageRequest request);
}
