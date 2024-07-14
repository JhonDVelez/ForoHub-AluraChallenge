package com.jdvelez.ForoHub_AluraChallenge.domain.usuario;

public record DatosListarUsuario(
        Long id,
        String nombre,
        Rol rol,
        Boolean activo
) {
    public DatosListarUsuario(Usuario usuario){
        this(usuario.getId(),usuario.getNombre(),usuario.getRol(), usuario.getActivo());
    }
}
