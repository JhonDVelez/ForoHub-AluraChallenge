package com.jdvelez.ForoHub_AluraChallenge.domain.curso;

public record DatosListarCurso(
        Long id,
        String nombre,
        String categoria,
        Boolean activo
) {
    public DatosListarCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.getActivo());
    }
}
