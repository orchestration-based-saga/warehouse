package com.saga.warehouse.infra.config;

import com.saga.warehouse.domain.in.WarehouseDomainServiceApi;
import com.saga.warehouse.domain.out.WarehouseRepositoryApi;
import com.saga.warehouse.domain.service.WarehouseDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeanConfiguration {

    @Bean
    public WarehouseDomainServiceApi warehouseDomainServiceApi(WarehouseRepositoryApi warehouseRepositoryApi) {
        return new WarehouseDomainService(warehouseRepositoryApi);
    }
}
