package com.saga.warehouse.domain.model;

public record DeliveredPackage(
        String packageId,
        boolean delivered
) {
}
