create table logError(

    id bigint not null auto_increment,
    method varchar(255) not null,
    message varchar(255) not null,
    stackTrace varchar(255) not null,

    primary key(id)

);