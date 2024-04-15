package com.tfc.tfc.LIGA.Repository.jdbc;

import com.tfc.tfc.LIGA.Model.Jugador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJdbcJugadorRepository {

    List<Jugador> buscarJugadorPorNombre(String nombre);

    List<Jugador> buscarMaximosGoleadoresDe1Liga(Integer codLiga);

    List<Jugador> buscarJugadoresDe1Equipo(Integer codEquipo);
}


