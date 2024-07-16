package com.jdvelez.ForoHub_AluraChallenge.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        Etiqueta tipo,
        @NotNull
        Long idCurso,
        @NotNull
        Long idCreador
) {
}
