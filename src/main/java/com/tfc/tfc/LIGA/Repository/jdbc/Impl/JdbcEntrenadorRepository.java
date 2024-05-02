package com.tfc.tfc.LIGA.Repository.jdbc.Impl;

import com.tfc.tfc.LIGA.Model.Entrenador;
import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcEntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class JdbcEntrenadorRepository implements IJdbcEntrenadorRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Entrenador> findEntrenadorWithNoTeam() {
        String QUERY="SELECT entrenador.* "+
                     "FROM entrenador "+
                     "LEFT JOIN equipos ON entrenador.id_entrenador = equipos.id_entrenador "+
                     "WHERE equipos.id_entrenador IS NULL "   ;
        return namedParameterJdbcTemplate.query(QUERY, new BeanPropertyRowMapper<>(Entrenador.class));
    }
}
