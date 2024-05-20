package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Dto.InfoEquipoEn1LigaOutputDto;
import org.springframework.http.HttpStatus;
import com.tfc.tfc.LIGA.Dto.ClasificacionOutputDto;
import com.tfc.tfc.LIGA.Model.Equipo;
import com.tfc.tfc.LIGA.Services.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("equipos")
public class EquipoController {
    private final EquipoService equipoService;

    @GetMapping("/clasificacion")
    public ResponseEntity<List<ClasificacionOutputDto>> clasificacionPorEquipo(@RequestParam Integer codLiga){
        return ResponseEntity.ok(equipoService.getEquiposByLiga(codLiga));
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> getEquiposByLiga(){
        return ResponseEntity.ok(equipoService.getAllEquipos());
    }

    @PostMapping
    public ResponseEntity<Equipo> addEquipo(@RequestBody Equipo equipo){
        return ResponseEntity.ok(equipoService.guardarEquipos(equipo));
    }
    @GetMapping("/maxId")
    public ResponseEntity<Integer> cogerMaxId(){
        return ResponseEntity.ok(equipoService.cogerMaxId());
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<Equipo>> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(equipoService.buscarPorNombre(nombre));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteEquipo(@RequestParam int id) {
        ResponseEntity<?> result = ResponseEntity.status(HttpStatus.OK).build();
        equipoService.eliminarEquipo(id);
        return result;
    }

    @PutMapping
    public ResponseEntity<Equipo> updateEquipo(@RequestBody Equipo equipo){
        return ResponseEntity.ok(equipoService.actualizarEquipo(equipo));
    }

    @GetMapping("/info")
    public ResponseEntity<InfoEquipoEn1LigaOutputDto> infoEquipo(@RequestParam Integer  codLiga, @RequestParam Integer codEquipo){
        return ResponseEntity.ok(equipoService.recuperarInfoDe1EquipoEn1Liga(codEquipo, codLiga));
    }

    @GetMapping("/liga")
    public ResponseEntity<List<Equipo>> equipos1Liga(@RequestParam Integer codLiga){
        return ResponseEntity.ok(equipoService.equiposDe1Liga(codLiga));
    }

}
