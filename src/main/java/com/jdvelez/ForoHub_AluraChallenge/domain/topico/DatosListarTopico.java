package com.jdvelez.ForoHub_AluraChallenge.domain.topico;

import java.time.LocalDateTime;

public record DatosListarTopico(
        Long id,
        String titulo,
        Etiqueta tipo,
        LocalDateTime fecha,
        Estado estado
) {
    public DatosListarTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getTipo(), topico.getFecha(), topico.getEstado());
    }
}
