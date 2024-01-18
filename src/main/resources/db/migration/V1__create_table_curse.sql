create table curse(
    id bigint not null auto_increment,
    name varchar(50),
    category varchar(50),
    primary key(id)
);

insert into curse values(1, 'javascript', 'programming');