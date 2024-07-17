package com.jdvelez.ForoHub_AluraChallenge.controller;

import com.jdvelez.ForoHub_AluraChallenge.domain.respuesta.*;
import com.jdvelez.ForoHub_AluraChallenge.domain.topico.TopicoRepository;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping("/{idTopico}")
    public ResponseEntity<DatosCompletosRespuesta> registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistro,
                                                                      @PathVariable Long idTopico,
                                                                      UriComponentsBuilder uriComponentsBuilder){
        Respuesta respuesta = new Respuesta(datosRegistro);
        respuesta.setIdTopico(topicoRepository.getReferenceById(idTopico));
        respuesta.setIdUsuario(usuarioRepository.getReferenceById(datosRegistro.idUsuario()));
        respuestaRepository.save(respuesta);
        DatosCompletosRespuesta datosCompletos = new DatosCompletosRespuesta(respuesta);
        URI url = uriComponentsBuilder.path("/topicos/{id}/{id}").buildAndExpand(idTopico,respuesta.getId()).toUri();
        return ResponseEntity.created(url).body(datosCompletos);
    }

    @GetMapping("/{idTopico}/{idRespuesta}")
    public ResponseEntity<DatosCompletosRespuesta> retornaDatosRespuesta(@PathVariable Long idRespuesta){
        Respuesta respuesta = respuestaRepository.getReferenceById(idRespuesta);
        return ResponseEntity.ok(new DatosCompletosRespuesta(respuesta));
    }

    @PutMapping("/{idTopico}/{idRespuesta}")
    @Transactional
    public ResponseEntity<DatosCompletosRespuesta> actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizados,
                                                                       @PathVariable Long idRespesta){
        Respuesta respuesta = respuestaRepository.getReferenceById(idRespesta);
        respuesta.actualizarRespuesta(datosActualizados);
        return ResponseEntity.ok(new DatosCompletosRespuesta(respuesta));
    }

    @DeleteMapping("/{idTopico}/{idRespuesta}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long idRespuesta){
        Respuesta respuesta = respuestaRepository.getReferenceById(idRespuesta);
        respuesta.desactivarRespuesta();
        return ResponseEntity.noContent().build();
    }
}
