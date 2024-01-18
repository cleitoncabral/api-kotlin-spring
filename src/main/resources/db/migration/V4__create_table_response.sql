create table response(
    id bigint primary key auto_increment,
    message varchar(500) not null,
    date_creation timestamp not null,
    author_id bigint not null,
    curse_id bigint not null,
    solution boolean not null,
    foreign key(author_id) references author,
    foreign key(curse_id) references curse
);