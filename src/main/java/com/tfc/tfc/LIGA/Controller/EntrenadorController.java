package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Model.Entrenador;
import com.tfc.tfc.LIGA.Services.EntrenadorService;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @GetMapping
    private ResponseEntity<List<Entrenador>> getEntrenadores() {
        return ResponseEntity.ok(entrenadorService.findAllEntrenadores());
    }

    @GetMapping("/entrenador")
    private ResponseEntity<Entrenador> getEntrenadorById(@RequestParam Integer id) {
        return ResponseEntity.ok(entrenadorService.findEntrenadorPorId(id));
    }

    @DeleteMapping
    private ResponseEntity<?> EliminarEntrenadorByID(@RequestParam Integer id) {
        ResponseEntity<?> result = ResponseEntity.status(HttpStatus.OK).build();
        entrenadorService.eliminarEntrenador(entrenadorService.findEntrenadorPorId(id));
        return result;
    }

    @PostMapping
    private ResponseEntity<Entrenador> postEntrenador(@RequestBody Entrenador entrenador) {
        return ResponseEntity.ok((entrenadorService.guardarEntrenador(entrenador)));

    }

    @GetMapping("/libres")
    private ResponseEntity<List<Entrenador>> getEntrenadoresLibres() {
        return ResponseEntity.ok(entrenadorService.findEntrenadorWithNoTeam());
    }


    @GetMapping("/nombre")
    private ResponseEntity<List<Entrenador>> getEntrenadoresPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(entrenadorService.findEntrenador(nombre));
    }

    @PutMapping
    private ResponseEntity<?> updateEntrenador(@RequestBody Entrenador entrenador) {
        entrenadorService.actualizarEntrenador(entrenador);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/equipo")
    private ResponseEntity<?> updateEntrenadorEn1Equipo(@RequestBody Entrenador entrenador, @RequestParam Integer idEquipo) {
        entrenadorService.actualizarEntrenadorDeEquipo(entrenador, idEquipo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    private ResponseEntity<Entrenador> findEntrenadorPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(entrenadorService.findEntrenadorPorId(id));
    }

}
