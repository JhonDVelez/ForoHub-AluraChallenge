package com.jdvelez.ForoHub_AluraChallenge.domain.topico;

import com.jdvelez.ForoHub_AluraChallenge.domain.curso.Curso;
import com.jdvelez.ForoHub_AluraChallenge.domain.respuesta.Respuesta;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Enumerated(EnumType.STRING)
    private Etiqueta tipo;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="curso_id")
    private Curso idCurso;
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="creador_id")
    private Usuario idCreador;
    @Setter
    @OneToMany(mappedBy = "idTopico")
    private List<Respuesta> respuestas;

    public Topico(DatosRegistroTopico datosRegistro) {
        this.titulo = datosRegistro.titulo();
        this.mensaje = datosRegistro.mensaje();
        if (datosRegistro.tipo() == null)
            this.tipo = Etiqueta.NINGUNA;
        else
            this.tipo = datosRegistro.tipo();
        this.fecha = LocalDateTime.now();
        this.estado = Estado.ABIERTO;
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizados) {
        this.titulo = datosActualizados.titulo();
        this.mensaje = datosActualizados.mensaje();
        this.estado = datosActualizados.estado();
    }

    public void desactivarTopico(){
        this.estado = Estado.ELIMINADO;
    }
}
