package com.tfc.tfc.LIGA.Repository.jdbc.Impl;

import com.tfc.tfc.LIGA.Dto.ClasificacionOutputDto;
import com.tfc.tfc.LIGA.Dto.InfoEquipoEn1LigaOutputDto;
import com.tfc.tfc.LIGA.Model.Equipo;
import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcEquiposRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcEquipoRepositoryImpl implements IJdbcEquiposRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<ClasificacionOutputDto> clasificacionEquipos(Integer codLiga) {
        String QUERY = "select e.*, el.puntos from equipos e " +
                "inner join equipo_liga el on el.Cod_equipo = e.id_equipo " +
                "where el.Cod_liga = :codliga " +
                "order by el.puntos desc";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codliga", codLiga);
        return namedParameterJdbcTemplate.query(QUERY, params, new BeanPropertyRowMapper<>(ClasificacionOutputDto.class));
    }

    @Override
    public Integer cogerMaxId() {
        String QUERY = "select * from equipos ORDER BY id_equipo DESC";
        MapSqlParameterSource map=new MapSqlParameterSource();
         List <Equipo> a=namedParameterJdbcTemplate.query(QUERY, map,new BeanPropertyRowMapper<>(Equipo.class));
         return a.get(0).getIdEquipo();
    }

    @Override
    public List<Equipo> buscarEquiposPorNombre(String nombre) {
        String QUERY = "SELECT * FROM equipos WHERE equipos.nombre_equipo LIKE CONCAT(:nombre, '%')";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nombre", nombre);
        return namedParameterJdbcTemplate.query(QUERY, params, new BeanPropertyRowMapper<>(Equipo.class));
    }

    @Override
    public InfoEquipoEn1LigaOutputDto infoEquipo(Integer codEquipo, Integer codLiga) {
        String QUERY = "SELECT el.Cod_equipo as codEquipo, el.Cod_liga as codLiga, el.puntos, el.partidos_jugados as partidosJugados,el.partidos_jugados as partidosGanados, "
                    + "el.partidos_perdidos as partidosPerdidos, el.partidos_empatados as partidosEmpatados, el.goles_a_favor as golesFavor, "
                    + "el.goles_en_contra as golesContra "
                    + "FROM equipo_liga el "
                    + "WHERE el.Cod_equipo = :codEquipo and el.Cod_liga = :codLiga";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codEquipo", codEquipo);
        params.addValue("codLiga", codLiga);
        List<InfoEquipoEn1LigaOutputDto> lista = namedParameterJdbcTemplate.query(QUERY, params, new BeanPropertyRowMapper<>(InfoEquipoEn1LigaOutputDto.class));
        return lista.get(0);
    }

    @Override
    public List<Equipo> equiposDe1Liga (Integer codLiga) {
        String QUERY = "select e.* from equipos e " +
                "inner join equipo_liga el on el.Cod_equipo = e.id_equipo " +
                "where el.Cod_liga = :codliga " +
                "order by el.puntos desc";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codliga", codLiga);
        return namedParameterJdbcTemplate.query(QUERY, params, new BeanPropertyRowMapper<>(Equipo.class));
    }

}
