create database amazoom;

CREATE USER 'test'@'localhost' IDENTIFIED BY 'testPWD';
GRANT ALL PRIVILEGES ON * . * TO 'test'@'localhost';

create table clients (
  id                        bigint not null,
  firstname                 varchar(100),
  lastname                  varchar(100),
  zipcode                   varchar(10),
  constraint pk_clients primary key (id)
);

create table purchases (
  id                        bigint not null,
  client_id                 bigint not null,
  itemName                  varchar(100),
  price                     bigint not null,
  purchaseDate              DATETIME,
  constraint pk_purchases primary key (id)
);

alter table purchases add constraint fk_purchases_1 foreign key (client_id) references clients (id);

