package com.tfc.tfc.LIGA.Repository.jdbc;

import com.tfc.tfc.LIGA.Model.Entrenador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJdbcEntrenadorRepository {

    List<Entrenador> findEntrenadorWithNoTeam();

    List<Entrenador> findEntrenadorPorNombre(String nombre);
}
