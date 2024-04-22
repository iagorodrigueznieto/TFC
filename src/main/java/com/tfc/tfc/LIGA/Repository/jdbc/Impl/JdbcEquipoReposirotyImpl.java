package com.tfc.tfc.LIGA.Repository.jdbc.Impl;

import com.tfc.tfc.LIGA.Model.Equipos;
import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcEquiposRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcEquipoReposirotyImpl implements IJdbcEquiposRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Equipos> clasificacionEquipos(Integer codLiga) {
        String QUERY = "select e.nombre, el.puntos from equipos e " +
                "inner join equipo_liga el on el.Cod_equipo = e.id_equipo " +
                "where el.Cod_liga = :codliga" +
                "order by el.puntos desc";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codliga", codLiga);
        return namedParameterJdbcTemplate.query(QUERY, params, new BeanPropertyRowMapper<>(Equipos.class));
    }
}
