package com.jdvelez.ForoHub_AluraChallenge.domain.respuesta;

import com.jdvelez.ForoHub_AluraChallenge.domain.topico.Topico;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean activo;
    @Setter
    @ManyToOne
    @JoinColumn(name="topico_id")
    private Topico idTopico;
    @Setter
    @OneToOne
    @JoinColumn(name="usuario_id")
    private Usuario idUsuario;

    public Respuesta(DatosRegistroRespuesta datosRegistro) {
        this.mensaje = datosRegistro.mensaje();
        this.fecha = LocalDateTime.now();
        this.activo = true;
    }

    public void actualizarRespuesta(DatosActualizarRespuesta datosActualizados) {
        this.mensaje = datosActualizados.mensaje();
    }

    public void desactivarRespuesta() {
        this.activo = false;
    }
}
