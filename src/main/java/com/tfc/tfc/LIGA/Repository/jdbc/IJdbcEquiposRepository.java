package com.tfc.tfc.LIGA.Repository.jdbc;

import com.tfc.tfc.LIGA.Dto.ClasificacionOutputDto;
import com.tfc.tfc.LIGA.Model.Equipo;

import java.util.List;

public interface IJdbcEquiposRepository {

    List<ClasificacionOutputDto>  clasificacionEquipos(Integer codLiga);

    Integer cogerMaxId();
}
