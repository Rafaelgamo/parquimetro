create table parquimetro (
        id bigint not null auto_increment,
        placa varchar(100) not null,
        data varchar(8) not null,
        valor float(30)not null,

        primary key(id)

)