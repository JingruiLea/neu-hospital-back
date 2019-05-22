create table user (
  id int not null auto_increment,
  username varchar(255) not null,
  password varchar(300) not null,
  primary key(id),
  unique(username)
);

create table role (
  id int not null auto_increment,
  name varchar(255) not null,
  primary key(id)
);

create table role_user (
  id int not null auto_increment,
  user_id int not null,
  role_id int not null,
  primary key(id)
);

create table permission(
  id int not null auto_increment,
  name varchar(255) not null,
  discription varchar(255) not null,
  url varchar(255) not null,
  pid int,
  primary key(id)
);