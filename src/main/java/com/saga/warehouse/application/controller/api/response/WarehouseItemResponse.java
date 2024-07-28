package com.saga.warehouse.application.controller.api.response;

import com.saga.warehouse.application.controller.api.enums.WarehouseItemStatus;

public record WarehouseItemResponse(
        Integer merchantInventoryId,
        WarehouseItemStatus status,
        String packageId
) {
}
