package com.saga.warehouse.domain.model;

public record Package(
        String packageId,
        Integer amount,
        String courierName
) {
}
