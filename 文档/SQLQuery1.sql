CREATE DATABASE Hospital
GO
USE Hospital
GO
CREATE TABLE Patient(
	ID char(18) primary key,
	Pa_id char(20) not null,
	Pa_name char(20) not null,
	Pa_age int not null,
	Pa_sex char(4) not null,
	De_id char(20) not null,
	Do_id char(20) not null,
	Pa_state int not null,
	Pa_cost float
)
GO
ALTER TABLE Patient add Pa_prescription char(200)
ALTER TABLE Patient add Pa_illness char(100)
ALTER TABLE Patient add Pa_time datetime not null
GO

CREATE TABLE Department(
	De_id char(20) primary key,
	De_name char(50) not null
)
GO
CREATE TABLE Doctor(
	Do_id char(20) primary key,
	Do_name char(20) not null,
	Do_sex char(4) not null,
	Do_age int not null,
	De_id char(20)not null,
	Do_prof char(20) not null,
	Do_tel char(11) not null
)
GO
ALTER TABLE Doctor add Do_state int not null
GO

CREATE TABLE Medicine(
	Me_id char(20) primary key,
	Me_name char(50) not null,
	Me_price float not null,
	Me_inventory int not null
)
GO
CREATE TABLE Account(
	Ac_id char(20) primary key,
	Ac_pwd char(20) not null,
	Ac_prof char(10) not null
)
GO

ALTER TABLE Department add De_earn float

CREATE ROLE director
GRANT SELECT ON Account TO director
GRANT SELECT ON Department TO director
GRANT SELECT ON Doctor TO director
GRANT SELECT ON Medicine TO director
GRANT SELECT ON Patient TO director

CREATE ROLE doctor
GRANT SELECT ON Patient TO doctor
GRANT SELECT ON Medicine TO doctor

CREATE ROLE pharmacist
GRANT SELECT ON Patient TO pharmacist
GRANT SELECT ON Doctor TO pharmacist
GRANT SELECT,UPDATE ON Medicine TO pharmacist

CREATE ROLE patient
GRANT SELECT,UPDATE ON Patient TO patient
GRANT SELECT ON Department TO patient
GRANT SELECT ON Doctor TO patient

CREATE ROLE toll
GRANT SELECT,UPDATE ON Patient TO toll
GRANT SELECT ON Medicine TO toll

CREATE ROLE administrator
GRANT SELECT,UPDATE ON Medicine TO administrator
GRANT SELECT,UPDATE ON Account TO administrator
GRANT SELECT,UPDATE ON Department TO administrator
