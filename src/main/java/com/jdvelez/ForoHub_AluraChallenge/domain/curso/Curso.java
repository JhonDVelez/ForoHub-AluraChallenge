package com.jdvelez.ForoHub_AluraChallenge.domain.curso;

import com.jdvelez.ForoHub_AluraChallenge.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    private Boolean activo;
    @Setter
    @OneToMany(mappedBy = "idCurso")
    private List<Topico> topicos;

    public Curso(DatosRegistroCurso datosRegistro) {
        this.nombre = datosRegistro.nombre();
        this.categoria = datosRegistro.categoria();
        this.activo = true;
    }

    public void actualizarCurso(DatosActualizarCurso datosActualizar) {
        if(datosActualizar.nombre() != null)
            this.nombre = datosActualizar.nombre();
        if(datosActualizar.categoria() != null)
            this.categoria = datosActualizar.categoria();
    }

    public void desactivarCurso(){
        this.activo = false;
    }
}
