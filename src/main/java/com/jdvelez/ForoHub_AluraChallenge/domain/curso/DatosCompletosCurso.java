package com.jdvelez.ForoHub_AluraChallenge.domain.curso;

import com.jdvelez.ForoHub_AluraChallenge.domain.topico.DatosListarTopico;

import java.util.List;

public record DatosCompletosCurso(
        Long id,
        String nombre,
        String categoria,
        Boolean activo,
        List<DatosListarTopico> topicos
) {
    public DatosCompletosCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.getActivo(),
                curso.getTopicos().stream().map(DatosListarTopico::new).toList());
    }
}