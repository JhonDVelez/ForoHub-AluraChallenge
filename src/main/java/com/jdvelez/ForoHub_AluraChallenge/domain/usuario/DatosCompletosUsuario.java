package com.jdvelez.ForoHub_AluraChallenge.domain.usuario;

public record DatosCompletosUsuario(
         Long id,
         String nombre,
         String email,
         String clave,
         Rol rol,
         Boolean activo
) {
    public DatosCompletosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getClave(), usuario.getRol(), usuario.getActivo());
    }
}
