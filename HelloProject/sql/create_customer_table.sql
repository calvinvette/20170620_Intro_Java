--create database weasley;
drop table customer;

create table customer (
	customerId integer not null generated always as identity, 
	firstName varchar(25),
	lastName varchar(25),
	phoneNumber varchar(25),
	email varchar(125)
);

