package com.saga.warehouse.infra.model;

import com.saga.warehouse.infra.model.enums.ItemStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "WarehouseItem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String courierName;
    String packageId;
    @OneToOne
    @JoinColumn(name = "merchant_inventory_id", referencedColumnName = "merchant_inventory_id")
    MerchantProductEntity product;
    @Enumerated(EnumType.STRING)
    ItemStatus status;
}
