create table application_for_equipment
(
    id            uuid         not null
        primary key,
    amount        integer      not null,
    justification varchar(255) not null,
    date          timestamp    not null,
    status        varchar(15)  not null,
    title         varchar(50)  not null,
    type          varchar(50)  not null
);

alter table application_for_equipment
    owner to postgres;

create table report
(
    id              bigint       not null
        primary key,
    date            date,
    form_date       date,
    form_number     bigint,
    mailing_address varchar(255),
    name_company    varchar(255) not null,
    okpo_num        varchar(255)
);

alter table report
    owner to postgres;

create table commissioned_wells
(
    id                bigint       not null
        primary key,
    dormant           integer      not null,
    from_conservation integer      not null,
    from_drilling     integer      not null,
    from_other_funds  integer      not null,
    in_all            integer      not null,
    name              varchar(255) not null,
    report_id         bigint
        constraint fk1gof6puo2w57oswpq1u9qkwvv
            references report
);

alter table commissioned_wells
    owner to postgres;

create table executive
(
    id        bigint      not null
        primary key,
    email     varchar(50) not null,
    full_name varchar(50) not null,
    position  varchar(50) not null,
    telephone integer     not null,
    report_id bigint
        constraint fkit5m7ijqssh3v9j0lij3jy2rp
            references report
);

alter table executive
    owner to postgres;

create table fund_calendar_time
(
    id                 bigint           not null
        primary key,
    active_fund        double precision not null,
    downtime           double precision not null,
    name               varchar(255)     not null,
    not_active         double precision not null,
    operating_fund     double precision not null,
    operating_time     double precision not null,
    pending            double precision not null,
    without_production double precision not null,
    report_id          bigint
        constraint fk96ml9d2j8snnoowx2xvcqnbly
            references report
);

alter table fund_calendar_time
    owner to postgres;

create table gas_production
(
    id          bigint           not null
        primary key,
    burnt       double precision not null,
    consumption double precision not null,
    losses      double precision not null,
    production  double precision not null,
    report_id   bigint
        constraint fkfrl0axf3qk3tevwc9eqt6y50c
            references report
);

alter table gas_production
    owner to postgres;

create table oil_movement
(
    id        bigint           not null
        primary key,
    name      varchar(255)     not null,
    number    double precision not null,
    report_id bigint
        constraint fkqtu6vjmo9xg8qtaqci25i4rqx
            references report
);

alter table oil_movement
    owner to postgres;

create table oil_preparation
(
    id        bigint           not null
        primary key,
    actually  double precision not null,
    showing   varchar(255)     not null,
    report_id bigint
        constraint fkl8fstk3mq2nb7e8wfy97j2ifl
            references report
);

alter table oil_preparation
    owner to postgres;

create table oil_production
(
    mining_method    varchar(31)      not null,
    id               bigint           not null
        primary key,
    average_flow     double precision not null,
    extracted_liquid double precision not null,
    oil              double precision not null,
    production_wells integer          not null,
    registered_wells integer          not null,
    worked_wells     integer          not null,
    report_id        bigint
        constraint fk17lgmfhpg8mwg3vk7d9da73s3
            references report
);

alter table oil_production
    owner to postgres;

create table reservoir_oil_production
(
    id                  bigint           not null
        primary key,
    method_of_influence varchar(255)     not null,
    oil_production      double precision not null,
    production_increase double precision not null,
    report_id           bigint
        constraint fkndwsvs3x4s1aggf5iqjvrmud6
            references report
);

alter table reservoir_oil_production
    owner to postgres;

create table well_fund
(
    id              bigint       not null
        primary key,
    name            varchar(255) not null,
    number_of_wells integer      not null,
    report_id       bigint
        constraint fkorhfp64kyn6hf057esltg01x3
            references report
);

alter table well_fund
    owner to postgres;

