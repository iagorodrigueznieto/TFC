package com.tfc.tfc.User.Controller;

import com.tfc.tfc.User.Model.Usuarios;
import com.tfc.tfc.User.Services.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UsuarioService usuarioService;


    @GetMapping("/{id}")
    public Usuarios getUsuarioByID(@PathVariable Long id) {
        Usuarios user = usuarioService.getUsuariosById(id);
        return user;
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> getUsuarios() {
      return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }
}
