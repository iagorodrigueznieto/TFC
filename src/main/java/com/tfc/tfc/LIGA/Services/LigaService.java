package com.tfc.tfc.LIGA.Services;

import com.tfc.tfc.LIGA.Dto.InfoEquipoEn1LigaOutputDto;
import com.tfc.tfc.LIGA.Model.Liga;
import com.tfc.tfc.LIGA.Repository.LigaRepository;
import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcLigaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LigaService {

    private final LigaRepository ligaRepository;


    @Qualifier("IJdbcLigaRepository")
    private final IJdbcLigaRepository jdbcLigaRepository;


    public Liga crearLiga(Liga liga) {
        return ligaRepository.save(liga);
    }

    public List<Liga> getAllLigas() {
        return ligaRepository.findAll();
    }

    public Liga getLigaById(int id) {
        return ligaRepository.findById(id).orElse(null);
    }

    public void deleteLiga(Liga liga) {
        ligaRepository.delete(liga);
    }

    public void deleteEquipoLiga(Integer codEquipo,Integer codLiga){
        jdbcLigaRepository.eliminar1Equipod1liga(codEquipo,codLiga);
    }

    public void modificarEquipoLiga(InfoEquipoEn1LigaOutputDto  infoEquipoEn1LigaOutputDto){
        jdbcLigaRepository.modificarEquipoLiga(infoEquipoEn1LigaOutputDto);
    }



}
