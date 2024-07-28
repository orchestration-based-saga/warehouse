alter table warehouse_item
    add column merchant_inventory_id integer references merchant_product (merchant_inventory_id) not null;