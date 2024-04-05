package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Model.Jugador;
import com.tfc.tfc.LIGA.Services.JugadorService;
import com.tfc.tfc.User.Services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jugadores")
@RequiredArgsConstructor
@Validated
public class JugadorController {
    private final JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<Jugador>> getAllPlayers(){
        return ResponseEntity.ok(jugadorService.getAllPlayers());
    }

}
