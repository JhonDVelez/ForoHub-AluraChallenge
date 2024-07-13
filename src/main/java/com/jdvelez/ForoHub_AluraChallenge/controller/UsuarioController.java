package com.jdvelez.ForoHub_AluraChallenge.controller;

import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.DatosRegistroUsuario;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.Usuario;
import com.jdvelez.ForoHub_AluraChallenge.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarUsuario(@RequestBody DatosRegistroUsuario datosRegistro){
        usuarioRepository.save(new Usuario(datosRegistro));
    }
}
