package com.tfc.tfc.LIGA.Repository.jdbc;

import com.tfc.tfc.LIGA.Dto.ClasificacionOutputDto;
import com.tfc.tfc.LIGA.Dto.InfoEquipoEn1LigaOutputDto;
import com.tfc.tfc.LIGA.Model.Equipo;

import java.util.List;

public interface IJdbcEquiposRepository {

    List<ClasificacionOutputDto>  clasificacionEquipos(Integer codLiga);

    Integer cogerMaxId();

    List<Equipo> buscarEquiposPorNombre(String nombre);

    InfoEquipoEn1LigaOutputDto infoEquipo(Integer codEquipo,Integer codLiga);

    List<Equipo> equiposDe1Liga(Integer codLiga);
    
}
