package com.saga.warehouse.application.controller.api.request;

public record PackageRequest(
        String packageId,
        String courier,
        Integer merchantInventoryId
) {
}
