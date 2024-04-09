package com.tfc.tfc.LIGA.Controller;

import com.tfc.tfc.LIGA.Model.Liga;
import com.tfc.tfc.LIGA.Services.LigaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
