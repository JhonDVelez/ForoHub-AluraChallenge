package com.jdvelez.ForoHub_AluraChallenge.controller;

import com.jdvelez.ForoHub_AluraChallenge.domain.curso.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Cursos")
public class CursoController{
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<Page<DatosCompletosCurso>> listarCursos(@PageableDefault(size = 2) Pageable paginacion){
        return ResponseEntity.ok(cursoRepository.findAll(paginacion).map(DatosCompletosCurso::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosCompletosCurso> retornaDatosCurso(@PathVariable Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosCompletosCurso(curso));
    }

    @PostMapping
    public ResponseEntity<DatosCompletosCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistro,
                                         UriComponentsBuilder uriComponentsBuilder){
        Curso curso = new Curso(datosRegistro);
        DatosCompletosCurso datosCompletos = new DatosCompletosCurso(curso);
        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosCompletos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosCompletosCurso> actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizar){
        Curso curso = cursoRepository.getReferenceById(datosActualizar.id());
        curso.actualizarCurso(datosActualizar);
        return ResponseEntity.ok(new DatosCompletosCurso(curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        curso.desactivarCurso();
        return ResponseEntity.noContent().build();
    }


}
