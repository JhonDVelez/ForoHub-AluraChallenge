ALTER TABLE respuestas ADD activo tinyint not null;
update respuestas set activo = 1;