package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Model.Entrenador;
import com.tfc.tfc.LIGA.Services.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    private ResponseEntity<Entrenador> getEntrenadorById(Integer id) {
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

        if (entrenadorService.findEntrenadorPorId(entrenador.getIdEntrenador()) == null) {
            return ResponseEntity.ok((entrenadorService.guardarEntrenador(entrenador)));
        } else {
            return ResponseEntity.ok(entrenador);
        }


    }


}
