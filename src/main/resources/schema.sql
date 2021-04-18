create table if not exists battle (
    id bigint not null,
    primary key (id)
);
create table if not exists battle_samurais (
    battle_id bigint not null,
    samurais_id bigint not null
);
create table if not exists samurai (
    name varchar(255),
    id bigint not null,
    amount bigint,
    creation_date timestamp,
    description varchar(255),
    samurai_type integer,
    quote_id bigint,
    price decimal(19,2),
    primary key (id)
);
create table if not exists samurai_quote (
    id bigint not null,
    samurai_id bigint not null,
    quote varbinary(max),
    name varchar(255),
    primary key (id)
);

alter table battle_samurais add constraint FK4q9gnl10yamqxew6rs2wdk0qq foreign key (samurais_id) references samurai;
alter table battle_samurais add constraint FKh8ugq8wukffh0bpp01ct2p49t foreign key (battle_id) references battle;
alter table samurai_quote add constraint UKh8ugq8wukffh0bpp01ct2p49t foreign key (samurai_id) references samurai;
