create table cart
(
    USER_ID  int  not null,
    CONTENTS text null
);

create table category
(
    CATEGORY_ID   int auto_increment
        primary key,
    CATEGORY_NAME varchar(32) not null
);

create table product
(
    PRODUCT_ID          int auto_increment
        primary key,
    PRODUCT_NAME        varchar(50)     not null,
    PRODUCT_DESCRIPTION varchar(255)    null,
    PRODUCT_PRICE       float default 0 null,
    PRODUCT_QUANTITY    int   default 0 null,
    PRODUCT_CATEGORY    varchar(32)     not null
);

create table role
(
    ROLE_ID   int         not null
        primary key,
    ROLE_NAME varchar(50) not null
);

create table user
(
    USER_ID      int auto_increment
        primary key,
    FIRST_NAME   varchar(50)          not null,
    LAST_NAME    varchar(50)          not null,
    EMAIL        varchar(100)         not null,
    PHONE_NUMBER varchar(10)          not null,
    USERNAME     varchar(32)          not null,
    PASSWORD     varchar(255)         not null,
    IS_ACTIVE    tinyint(1) default 1 null,
    ROLE         int        default 4 null,
    constraint USER_EMAIL_uindex
        unique (EMAIL),
    constraint USER_USERNAME_uindex
        unique (USERNAME),
    constraint USER_ROLE_ROLE_ID_fk
        foreign key (ROLE) references role (ROLE_ID)
);

