package com.jdvelez.ForoHub_AluraChallenge.domain.respuesta;

import com.jdvelez.ForoHub_AluraChallenge.domain.topico.Topico;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @ManyToOne
    private Topico idTopico;
    @OneToOne
    private Usuario idUsuario;
    private String mensaje;
    private LocalDateTime fecha;
}
