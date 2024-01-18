create table topic(
    id bigint not null auto_increment,
    title varchar(50) not null,
    message varchar(500) not null,
    date_creation timestamp not null,
    status varchar(50) not null,
    curse_id bigint not null,
    author_id bigint not null,
    primary key(id),
    foreign key(curse_id) references Curse,
    foreign key(author_id) references Author
);