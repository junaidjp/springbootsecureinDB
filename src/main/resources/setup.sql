create table users(
username varchar(75) not null primary key,
password varchar(150) not null,
enabled boolean not null
);


create table authorities (
username varchar(75) not null,
authority varchar(50) not null,
constraint fk_authorities_users foreign key(username) references users(username)
);



insert into users(username, password, enabled)
values('admin', 'admin@training',
true);

insert into users(username, password, enabled)
values('user', 'user@training',
true);


insert into authorities(username, authority)
values('admin','ROLE_ADMIN');

insert into authorities(username,authority)
values('user','ROLE_USER');



