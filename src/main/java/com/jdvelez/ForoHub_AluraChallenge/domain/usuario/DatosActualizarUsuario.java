package com.jdvelez.ForoHub_AluraChallenge.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull
        Long id,
        String nombre
) {
}
