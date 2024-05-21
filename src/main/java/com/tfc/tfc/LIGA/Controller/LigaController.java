package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Dto.InfoEquipoEn1LigaOutputDto;
import com.tfc.tfc.LIGA.Model.Liga;
import com.tfc.tfc.LIGA.Services.LigaService;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/liga")
public class LigaController {

    private final LigaService ligaService;

    @GetMapping
    private ResponseEntity<List<Liga>> getAllLiga() {
        return ResponseEntity.ok(ligaService.getAllLigas());
    }

    @GetMapping("/liga")
    private ResponseEntity<Liga> getLigaById(@RequestParam int id) {
        return ResponseEntity.ok(ligaService.getLigaById(id));
    }

    @PostMapping("/crear")
    private ResponseEntity<Liga> createLiga(@RequestBody Liga liga) {
            return ResponseEntity.ok(ligaService.crearLiga(liga));
    }

    @DeleteMapping
    private ResponseEntity<Liga> updateLiga(@RequestParam Integer codLiga) {
        return ResponseEntity.ok(ligaService.crearLiga(ligaService.getLigaById(codLiga)));
    }

    @DeleteMapping("/eliminar")
    private ResponseEntity<?> deleteLiga(@RequestParam Integer codEquipo,@RequestParam Integer codLiga) {
        ligaService.deleteEquipoLiga(codEquipo, codLiga);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    private ResponseEntity<?> modificarLiga(@RequestBody Liga liga){
        ligaService.modificarLiga(liga);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/info")
    private ResponseEntity<?> modificarEquipoLiga(@RequestBody InfoEquipoEn1LigaOutputDto  infoEquipoEn1LigaOutputDto) {
        ligaService.modificarEquipoLiga(infoEquipoEn1LigaOutputDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/insertar")
    private ResponseEntity<?> insertar1EquipoEn1liga(@RequestParam Integer codEquipo,@RequestParam Integer codLiga){
        ligaService.insertarEquipoEn1Liga(codEquipo,codLiga);
        return ResponseEntity.ok().build();
    }







}
