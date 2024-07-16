create table cursos(
    id bigint auto_increment not null,
    nombre varchar(100) not null,
    categoria varchar(100) not null,
    activo tinyint not null,

    primary key(id)
);

create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    tipo varchar(100),
    fecha datetime not null,
    estado varchar(100) not null,
    creador_id bigint not null,
    curso_id bigint not null,

    primary key(id),

    CONSTRAINT fk_topicos_cursos FOREIGN KEY(curso_id) REFERENCES cursos(id),
    CONSTRAINT fk_topicos_creador FOREIGN KEY(creador_id) REFERENCES usuarios(id)
);


