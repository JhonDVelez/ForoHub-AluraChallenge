package com.jdvelez.ForoHub_AluraChallenge.domain.usuario;

public record DatosRegistroUsuario(
        String nombre,
        String login,
        String clave,
        Rol rol
) {
}
