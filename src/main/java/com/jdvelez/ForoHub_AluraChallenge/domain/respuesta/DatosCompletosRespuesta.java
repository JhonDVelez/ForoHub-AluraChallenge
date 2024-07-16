package com.jdvelez.ForoHub_AluraChallenge.domain.respuesta;

import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.DatosCompletosUsuario;

import java.time.LocalDateTime;

public record DatosCompletosRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fecha,
        DatosCompletosUsuario usuario
) {
    public DatosCompletosRespuesta(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFecha(), new DatosCompletosUsuario(respuesta.getIdUsuario()));
    }
}
