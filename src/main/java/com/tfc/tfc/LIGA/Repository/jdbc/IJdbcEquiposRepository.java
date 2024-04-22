package com.tfc.tfc.LIGA.Repository.jdbc;

import com.tfc.tfc.LIGA.Model.Equipos;

import java.util.List;

public interface IJdbcEquiposRepository {

    List<Equipos>  clasificacionEquipos(Integer codLiga);
}
