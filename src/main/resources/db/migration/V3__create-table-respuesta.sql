create table respuestas(
    id bigint auto_increment not null,
    mensaje varchar(300) not null,
    fecha datetime not null,
    usuario_id bigint not null,
    topico_id bigint not null,

    primary key(id),

    CONSTRAINT fk_respuestas_usuario FOREIGN KEY(usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_respuestas_topico FOREIGN KEY(topico_id) REFERENCES topicos(id)
);