package com.saga.warehouse.domain.model;

import com.saga.warehouse.domain.model.enums.ItemStatusDomain;

public record Package(
        String packageId,
        String courierName,
        Integer merchantInventoryId,
        ItemStatusDomain status
) {
}
