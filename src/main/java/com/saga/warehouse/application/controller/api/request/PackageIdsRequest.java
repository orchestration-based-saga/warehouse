package com.saga.warehouse.application.controller.api.request;

import java.util.List;

public record PackageIdsRequest(
        List<String> packageIds
) {
}
