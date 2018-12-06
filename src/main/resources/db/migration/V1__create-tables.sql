create sequence hibernate_sequence start with 1 increment by 1;

create table animal_fact (
  id bigint not null,
  fact varchar(255),
  primary key (id)
)