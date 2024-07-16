package com.jdvelez.ForoHub_AluraChallenge.domain.topico;

import com.jdvelez.ForoHub_AluraChallenge.domain.curso.DatosListarCurso;
import com.jdvelez.ForoHub_AluraChallenge.domain.respuesta.DatosCompletosRespuesta;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.DatosCompletosUsuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosCompletosTopico(
        Long id,
        String titulo,
        String mensaje,
        Etiqueta tipo,
        LocalDateTime fecha,
        Estado estado,
        DatosCompletosUsuario creador,
        DatosListarCurso curso,
        List<DatosCompletosRespuesta> respuestas
) {
    public DatosCompletosTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getTipo(), topico.getFecha(), topico.getEstado(),
                new DatosCompletosUsuario(topico.getIdCreador()), new DatosListarCurso(topico.getIdCurso()),
                topico.getRespuestas().stream().map(DatosCompletosRespuesta::new).toList());
    }
}
