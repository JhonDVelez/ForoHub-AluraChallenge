package com.jdvelez.ForoHub_AluraChallenge.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(
        @NotNull
        Long id,
        String nombre,
        String categoria
) {
}
