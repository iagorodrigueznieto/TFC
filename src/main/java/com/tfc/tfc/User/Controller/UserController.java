package com.tfc.tfc.User.Controller;

import com.tfc.tfc.User.Model.Usuario;
import com.tfc.tfc.User.Services.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("usuarios")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuarios(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.CreateUsuario(usuario));
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String login, @RequestParam String password) {
        if (usuarioService.loginUsuario(login, password) == null) {
            return ResponseEntity.status(350).build();
        } else {
            return ResponseEntity.ok(usuarioService.loginUsuario(login, password));
        }
    }

}
