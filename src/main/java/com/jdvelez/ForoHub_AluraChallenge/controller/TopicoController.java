package com.jdvelez.ForoHub_AluraChallenge.controller;

import com.jdvelez.ForoHub_AluraChallenge.domain.curso.CursoRepository;
import com.jdvelez.ForoHub_AluraChallenge.domain.respuesta.RespuestaRepository;
import com.jdvelez.ForoHub_AluraChallenge.domain.topico.*;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;

    @GetMapping
    public ResponseEntity<Page<DatosListarTopico>> listarTopico(@PageableDefault(size = 5)Pageable paginacion){
        var query = topicoRepository.findAll(paginacion).stream().filter(t -> t.getEstado()!=Estado.ELIMINADO)
                .map(DatosListarTopico::new).toList();
        return ResponseEntity.ok(new PageImpl<>(query, paginacion, query.size()));
    }

    @PostMapping
    public ResponseEntity<DatosCompletosTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistro,
                                                                UriComponentsBuilder uriComponentsBuilder){
        Topico topico = new Topico(datosRegistro);
        topico.setIdCreador(usuarioRepository.getReferenceById(datosRegistro.idCreador()));
        topico.setIdCurso(cursoRepository.getReferenceById(datosRegistro.idCurso()));
        topico.setRespuestas(new ArrayList<>());
        topicoRepository.save(topico);
        DatosCompletosTopico datosCompletos = new DatosCompletosTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosCompletos);
    }

    @GetMapping("/{idTopico}")
    public ResponseEntity<DatosCompletosTopico> retornaDatosTopico(@PathVariable Long idTopico){
        Topico topico = topicoRepository.getReferenceById(idTopico);
        topico.setRespuestas(respuestaRepository.findAll().stream()
                .filter(r -> r.getIdTopico().getId().equals(topico.getId())).toList());
        return ResponseEntity.ok(new DatosCompletosTopico(topico));
    }

    @PutMapping("/{idTopico}")
    @Transactional
    public ResponseEntity<DatosCompletosTopico> actualizaDatosTopico(@RequestBody @Valid DatosActualizarTopico datosActualizados,
            @PathVariable Long idTopico){
        Topico topico = topicoRepository.getReferenceById(idTopico);
        topico.actualizarTopico(datosActualizados);
        return ResponseEntity.ok(new DatosCompletosTopico(topico));
    }

    @DeleteMapping("/{idTopico}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable long idTopico){
        Topico topico = topicoRepository.getReferenceById(idTopico);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
}
