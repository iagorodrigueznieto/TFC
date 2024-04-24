package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Dto.ClasificacionOutputDto;
import com.tfc.tfc.LIGA.Model.Equipo;
import com.tfc.tfc.LIGA.Services.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
