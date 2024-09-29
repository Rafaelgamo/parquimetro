create table parquimetro (
        id bigint not null auto_increment,
        placa varchar(100) not null,
        dia_hora TIMESTAMP not null,
        entrada TIME not null,
        saida TIME not null,
        permanecia VARCHAR(255),
        valor float(3),

        primary key(id)
)

