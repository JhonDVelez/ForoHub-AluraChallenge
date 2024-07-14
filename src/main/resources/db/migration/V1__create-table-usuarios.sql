create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null,
    clave varchar(300) not null,
    rol varchar(100),
    activo tinyint not null,

    primary key(id)
);

INSERT INTO usuarios (id,nombre, email, clave, rol, activo) VALUES (1,"admin","admin@email.com","admin","ROL_ADMIN",1);
