package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Model.Entrenador;
import com.tfc.tfc.LIGA.Services.EntrenadorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    private ResponseEntity<Entrenador> getEntrenadorById(Integer id) {
        return ResponseEntity.ok(entrenadorService.findEntrenadorPorId(id));
    }

    @DeleteMapping
    private ResponseEntity<?> EliminarEntrenadorByID(@RequestParam Integer id) {
        ResponseEntity<?> result = ResponseEntity.status(HttpStatus.OK).build();
        entrenadorService.EliminarEntrenador(entrenadorService.findEntrenadorPorId(id));
        return result;
    }
}
