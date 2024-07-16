package com.jdvelez.ForoHub_AluraChallenge.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String clave
) {
}
