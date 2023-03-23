create table weather
(
    id          bigint not null auto_increment,
    conditions  varchar(255),
    created_at  datetime(6),
    humidity    float(53),
    location    varchar(255),
    pressure    float(53),
    temperature float(53),
    wind        float(53),
    primary key (id)
) engine = InnoDB;

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (1, 'overcast clouds', '2023-03-21 00:00:00', 82, 'Minsk', 1012, 2.01, 3.94 );

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (2, 'overcast clouds', '2023-03-21 06:00:00', 84, 'Minsk', 1022, 2.21, 3.95 );

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (3, 'broken clouds', '2023-03-21 12:00:00', 83, 'Minsk', 1022, 6.86, 3.43);

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (4, 'overcast clouds', '2023-03-21 18:00:00', 83, 'Minsk', 1022, 8.15, 3.58);


insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (6, 'scattered clouds', '2023-03-22 00:00:00', 59, 'Minsk', 1003, 2.01, 5.15 );

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (7, 'overcast clouds', '2023-03-22 06:00:00', 62, 'Minsk', 1022, 2.21, 6.13 );

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (8, 'broken clouds', '2023-03-22 12:00:00', 63, 'Minsk', 1013, 7.33, 3.22);

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (9, 'few clouds', '2023-03-22 18:00:00', 58, 'Minsk', 1022, 9.86, 2.03);



insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (11, 'scattered clouds', '2023-03-23 00:00:00', 59, 'Minsk', 1010, 2.01, 5.15 );

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (12, 'broken clouds', '2023-03-23 06:00:00', 77, 'Minsk', 1012, 3.56, 6.13 );

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (13, 'overcast clouds', '2023-03-23 12:00:00', 63, 'Minsk', 1013, 5.86, 3.22);

insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (14, 'few clouds', '2023-03-23 18:00:00', 88, 'Minsk', 1022, 9.86, 2.03);



insert into weather (id, conditions, created_at, humidity, location, pressure, temperature, wind)
values (15, 'scattered clouds', '2023-03-24 00:00:00', 79, 'Minsk', 1022, 5.06, 4.55);
