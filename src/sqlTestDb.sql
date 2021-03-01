DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS baggage_weight;
DROP TABLE IF EXISTS STATUS;
DROP TABLE IF EXISTS user;

create table baggage_weight
(
    id int auto_increment primary key,
    weight varchar(25) not null
);

create table status
(
    id int auto_increment primary key,
    status_order varchar(25) not null
);

create table user
(
    id int auto_increment primary key,
    login    varchar(25)  not null,
    password varchar(255) null,
    role     varchar(25)  not null,
    email    varchar(55)  null,
    constraint login
        unique (login),
    constraint password
        unique (password),
    constraint user_email_uindex
        unique (email)
);

create table user_order
(
    id             int auto_increment
        primary key,
    from_city      varchar(55) null,
    to_city        varchar(55) null,
    time_way       varchar(50) null,
    road           int(25)     null,
    baggage_weight int         null,
    price          float       null,
    user_id        int         null,
    date           date        null,
    status         int         null,
    code           int         null,
    constraint user_order_ibfk_1
        foreign key (baggage_weight) references baggage_weight (id),
    constraint user_order_ibfk_2
        foreign key (user_id) references user (id),
    constraint user_order_ibfk_3
        foreign key (status) references status (id)
);

create index baggage_weight
    on user_order (baggage_weight);

create index status
    on user_order (status);

create index user_id
    on user_order (user_id);

INSERT INTO "PUBLIC"."BAGGAGE_WEIGHT" ("WEIGHT") VALUES ('light');
INSERT INTO "PUBLIC"."BAGGAGE_WEIGHT" ("WEIGHT") VALUES ('medium');
INSERT INTO "PUBLIC"."BAGGAGE_WEIGHT" ("WEIGHT") VALUES ('heavy');

INSERT INTO "PUBLIC"."STATUS" ("STATUS_ORDER") VALUES ('new');
INSERT INTO "PUBLIC"."STATUS" ("STATUS_ORDER") VALUES ('confirmed');
INSERT INTO "PUBLIC"."STATUS" ("STATUS_ORDER") VALUES ('paid');

INSERT INTO "PUBLIC"."USER" ("LOGIN", "PASSWORD", "ROLE", "EMAIL") VALUES ('Test', '098F6BCD4621D373CADE4E832627B4F6', 'USER', 'badalov.araz@gmail.com');

INSERT INTO "PUBLIC"."USER_ORDER" ("ID", "FROM_CITY", "TO_CITY", "TIME_WAY", "ROAD", "BAGGAGE_WEIGHT", "PRICE", "USER_ID", "DATE", "STATUS", "CODE") VALUES (1, 'Dn', 'Iv', '2 hour 21 m', 322, 2, 2123, 1, '2021-02-19', 2, null);