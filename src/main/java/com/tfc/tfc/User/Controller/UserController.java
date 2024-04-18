package com.tfc.tfc.User.Controller;

import com.tfc.tfc.User.Model.Usuarios;
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
    public ResponseEntity<List<Usuarios>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuarios> postUsuarios( @RequestBody Usuarios usuario) {
        return ResponseEntity.ok(usuarioService.CreateUsuario(usuario));
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String login, @RequestParam String password) {
        if (usuarioService.loginUsuario(login, password)) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

}
