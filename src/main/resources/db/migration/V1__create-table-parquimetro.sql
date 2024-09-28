create table parquimetro (
        id bigint not null auto_increment,
        placa varchar(100) not null,
        dia_hora TIMESTAMP,
        tempo TIME,
        valor float(30) not null,

        primary key(id)
)

