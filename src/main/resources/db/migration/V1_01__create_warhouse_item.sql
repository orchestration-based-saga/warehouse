create table if not exists warehouse_item(
    id serial not null primary key,
    package_id text,
    amount integer not null default 0,
    courier_name text
)