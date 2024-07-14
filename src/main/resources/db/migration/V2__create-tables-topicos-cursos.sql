create table cursos(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    categoria varchar(100) not null,

    primary key(id)
);

create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    tipo varchar(100),
    fecha datetime not null,
    idCreador bigint not null,
    idCurso bigint not null,

    primary key(id),

    CONSTRAINT fk_topicos_cursos FOREIGN KEY(idCurso) REFERENCES cursos(id),
    CONSTRAINT fk_topicos_creador FOREIGN KEY(idCreador) REFERENCES usuarios(id)
);

