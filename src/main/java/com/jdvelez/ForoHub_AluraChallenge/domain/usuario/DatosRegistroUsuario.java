package com.jdvelez.ForoHub_AluraChallenge.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        @Email
        String clave,
        @NotBlank
        Rol rol
) {
}
