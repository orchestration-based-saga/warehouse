package com.saga.warehouse.application.controller.api;

public record PackageRequest(
        Integer amount,
        String packageId,
        String courier
) {
}
