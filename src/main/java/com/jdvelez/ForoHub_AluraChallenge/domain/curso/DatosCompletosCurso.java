package com.jdvelez.ForoHub_AluraChallenge.domain.curso;

public record DatosCompletosCurso(
        Long id,
        String nombre,
        String categoria,
        Boolean activo
) {
    public DatosCompletosCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.getActivo());
    }
}
