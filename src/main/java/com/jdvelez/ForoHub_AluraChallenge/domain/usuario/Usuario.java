package com.jdvelez.ForoHub_AluraChallenge.domain.usuario;

import com.jdvelez.ForoHub_AluraChallenge.domain.respuesta.Respuesta;
import com.jdvelez.ForoHub_AluraChallenge.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String login;
    private String clave;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @OneToMany(mappedBy = "idCreador", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Topico> topicos;
    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;

    public Usuario(DatosRegistroUsuario datos) {
        this.rol = datos.rol();
        this.clave = datos.clave();
        this.login = datos.login();
        this.nombre = datos.nombre();
    }
}
