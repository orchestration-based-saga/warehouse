alter table warehouse_item drop column amount;
alter table warehouse_item add column status text not null default 'IN_DELIVERY';