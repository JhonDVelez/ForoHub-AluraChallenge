package com.jdvelez.ForoHub_AluraChallenge.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosCrearTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        Etiqueta etiqueta
) {
}
