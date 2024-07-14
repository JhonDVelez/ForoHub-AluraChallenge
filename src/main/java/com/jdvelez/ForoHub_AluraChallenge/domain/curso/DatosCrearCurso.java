package com.jdvelez.ForoHub_AluraChallenge.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCrearCurso(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}
