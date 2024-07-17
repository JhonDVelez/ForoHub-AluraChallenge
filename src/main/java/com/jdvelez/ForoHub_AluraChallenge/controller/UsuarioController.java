package com.jdvelez.ForoHub_AluraChallenge.controller;

import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<Page<DatosListarUsuario>> listarUsuarios(@PageableDefault(size = 2) Pageable paginacion){
        return ResponseEntity.ok(usuarioRepository.findByActivoTrue(paginacion).map(DatosListarUsuario::new));
    }

    @PostMapping
    public ResponseEntity<DatosCompletosUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistro,
                                           UriComponentsBuilder uriComponentsBuilder){
        DatosRegistroUsuario reg = new DatosRegistroUsuario(datosRegistro.nombre(), datosRegistro.email(),
                passwordEncoder.encode(datosRegistro.clave()));
        Usuario usuario = usuarioRepository.save(new Usuario(reg));
        DatosCompletosUsuario datosCompletos = new DatosCompletosUsuario(usuario);
        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosCompletos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosCompletosUsuario> actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizados){
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizados.id());
        usuario.actualizarUsuario(datosActualizados);
        return ResponseEntity.ok(new DatosCompletosUsuario(usuario));
    }

    // delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.desactivarUsuario();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosCompletosUsuario> retornaDatosUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosCompletosUsuario(usuario));
    }

}
