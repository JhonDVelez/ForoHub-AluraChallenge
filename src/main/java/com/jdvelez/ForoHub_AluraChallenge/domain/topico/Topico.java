package com.jdvelez.ForoHub_AluraChallenge.domain.topico;

import com.jdvelez.ForoHub_AluraChallenge.domain.curso.Curso;
import com.jdvelez.ForoHub_AluraChallenge.domain.respuesta.Respuesta;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @ManyToOne
    private Curso idCurso;
    @ManyToOne
    private Usuario idCreador;
    @OneToMany(mappedBy = "idTopico", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;
}
