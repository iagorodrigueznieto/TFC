package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Model.Jugador;
import com.tfc.tfc.LIGA.Services.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jugadores")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Validated
public class JugadorController {
    private final JugadorService jugadorService;

    @PutMapping
    public ResponseEntity<?> modificar(@RequestBody Jugador jugador) {
        ResponseEntity<?> result = ResponseEntity.status(HttpStatus.OK).build();
        jugadorService.modificarJugador(jugador);
        return result;
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Jugador jugador) {
        ResponseEntity<?> result = ResponseEntity.status(HttpStatus.OK).build();
        jugadorService.crearJugador(jugador);
        return result;
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> getAllPlayers() {
        return ResponseEntity.ok(jugadorService.getAllPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getPlayerById(@PathVariable int id) {
        return ResponseEntity.ok(jugadorService.getJugadorById(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Jugador>> getPlayerByNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(jugadorService.getJugadoresByName(nombre));
    }


    @GetMapping("/goleadores")
    public ResponseEntity<List<Jugador>> getMaximoJugadoresd1Liga(@RequestParam Integer numero) {
        return ResponseEntity.ok(jugadorService.getMaximosGoleadoresde1Liga(numero));
    }

    @GetMapping("/equipo")
    public ResponseEntity<List<Jugador>> getJugadoresDe1Equipo(@RequestParam Integer codEquipo) {
        return ResponseEntity.ok(jugadorService.getJugadoresDe1Equipo(codEquipo));
    }


    @DeleteMapping
    public ResponseEntity<?> deleteJugador(@RequestParam int id) {
        ResponseEntity<?> result = ResponseEntity.status(HttpStatus.OK).build();
        jugadorService.eliminarJugador(id);
        return result;
    }

    @GetMapping("/posicion")
    public ResponseEntity<List<Jugador>> getJugadoresDe1Posicion(@RequestParam Integer codEquipo, @RequestParam Integer posicion) {
        return ResponseEntity.ok(jugadorService.getJugadoresDe1EquipoEn1Posicion(codEquipo,posicion));
    }




}
