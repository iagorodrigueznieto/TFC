package com.tfc.tfc.LIGA.Repository.jdbc.Impl;

import com.tfc.tfc.LIGA.Model.Jugador;
import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RefreshScope
@RequiredArgsConstructor
public class JdbcJugadorRepositoryImpl implements IJdbcJugadorRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Jugador> buscarJugadorPorNombre(String nombre) {
        String QUERY = "select * from jugador where nombre LIKE CONCAT(:nombre, '%') ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nombre", nombre);
        return namedParameterJdbcTemplate.query(QUERY, params, new BeanPropertyRowMapper<>(Jugador.class));
    }

    @Override
    public List<Jugador> buscarMaximosGoleadoresDe1Liga(Integer codLiga) {
        String QUERY = "SELECT * from jugador j "
                + "inner join equipos e on e.id_equipo = j.id_equipo "
                + "inner join equipo_liga el on el.Cod_equipo = e.id_equipo and el.Cod_liga = :liga "
                + "order by j.goles desc ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("liga", codLiga);
        return namedParameterJdbcTemplate.query(QUERY, params, new BeanPropertyRowMapper<>(Jugador.class));
    }

    @Override
    public List<Jugador> buscarJugadoresDe1Equipo(Integer idEquipo) {
        String QUERY = "SELECT * from jugador j "
                + "WHERE id_equipo = :idEquipo ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idEquipo", idEquipo);
        return namedParameterJdbcTemplate.query(QUERY, params, new BeanPropertyRowMapper<>(Jugador.class));
    }
}
