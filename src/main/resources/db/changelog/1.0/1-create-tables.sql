create table equipment_request
(
    id                uuid         not null
        primary key,
    type_of_equipment varchar(50)  not null,
    date              date         not null,
    justification     varchar(255) not null,
    name              varchar(50)  not null,
    number            integer      not null,
    status            varchar(15)  not null
);


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


create table commissioned_wells
(
    id                bigint       not null
        primary key,
    dormant           integer,
    from_conservation integer,
    from_drilling     integer,
    from_other_funds  integer,
    in_all            integer      not null,
    name              varchar(255) not null,
    report_id         bigint
        constraint fk1gof6puo2w57oswpq1u9qkwvv
            references report
);


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


create table fund_calendar_time
(
    id                 bigint       not null
        primary key,
    active_fund        integer      not null,
    downtime           integer      not null,
    name               varchar(255) not null,
    not_active         integer,
    operating_fund     integer      not null,
    operating_time     integer      not null,
    pending            integer      not null,
    without_production integer      not null,
    report_id          bigint
        constraint fk96ml9d2j8snnoowx2xvcqnbly
            references report
);


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


create table oil_movement
(
    id                           bigint not null
        primary key,
    balance_at_the_beginning     double precision,
    balance_at_the_end           double precision,
    drilling                     double precision,
    expenses_for_technical_needs double precision,
    export                       double precision,
    extracted                    double precision,
    gas_processing               double precision,
    in_oil_pipelines             double precision,
    oil_and_gas_processing       double precision,
    oil_stabilized               double precision,
    other_organizations          double precision,
    released_to_enterprises      double precision,
    succumbed                    double precision,
    total                        double precision,
    total_consumption            double precision,
    total_handed_over            double precision,
    total_loss                   double precision,
    report_id                    bigint
        constraint fkqtu6vjmo9xg8qtaqci25i4rqx
            references report
);


create table oil_preparation
(
    id              bigint not null
        primary key,
    oil_losses      double precision,
    prepared_oil    double precision,
    received_liquid double precision,
    received_oil    double precision,
    report_id       bigint
        constraint fkl8fstk3mq2nb7e8wfy97j2ifl
            references report
);


create table oil_production
(
    id               bigint           not null
        primary key,
    average_flow     double precision,
    extracted_liquid double precision,
    mining_method    varchar(60)      not null,
    oil              double precision not null,
    production_wells integer,
    registered_wells integer,
    worked_wells     integer,
    report_id        bigint
        constraint fk17lgmfhpg8mwg3vk7d9da73s3
            references report
);


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


create table well_fund
(
    id                    bigint not null
        primary key,
    arrived_in_fund       integer,
    control               integer,
    development_work      integer,
    dormant_fund          integer,
    dropped_out_fund      integer,
    from_gas_fund         integer,
    in_active             integer,
    in_conservation       integer,
    injection             integer,
    liquidation_drilling  integer,
    liquidation_expl      integer,
    oil_gas_product       integer,
    in_start_year         integer,
    pending_liquidation   integer,
    stopped_last_month    integer,
    telemechanized        integer,
    total_active          integer,
    total_fund            integer,
    total_wells_fund      integer,
    waiting_after_work    integer,
    waste_water_discharge integer,
    water_intake          integer,
    report_id             bigint
        constraint fkorhfp64kyn6hf057esltg01x3
            references report
);
