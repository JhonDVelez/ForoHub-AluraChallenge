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
    private String email;
    private String clave;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private Boolean activo;
    @OneToMany(mappedBy = "idCreador", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Topico> topicos;
    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas;

    public Usuario(DatosRegistroUsuario datos) {
        this.activo = true;
        this.rol = Rol.ROL_MIEMBRO;
        this.clave = datos.clave();
        this.email = datos.email();
        this.nombre = datos.nombre();
    }

    public void actualizarUsuario(DatosActualizarUsuario datosActualizados) {
        if(datosActualizados.nombre() != null)
            this.nombre = datosActualizados.nombre();
    }

    public void desactivarUsuario() {
        this.activo = false;
    }
}
