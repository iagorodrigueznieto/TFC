package com.tfc.tfc.LIGA.Repository.jdbc.Impl;

import com.tfc.tfc.LIGA.Dto.InfoEquipoEn1LigaOutputDto;
import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcLigaRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JdbcLigaRepositoryImpl implements IJdbcLigaRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int eliminar1Equipod1liga(Integer codEquipo,Integer codLiga) {
        final String DELETE_QUERY = "DELETE FROM equipo_liga WHERE Cod_Equipo = :codEquipo and Cod_liga = :codLiga";
        MapSqlParameterSource params =new MapSqlParameterSource();
        params.addValue("codEquipo",codEquipo);
        params.addValue("codLiga", codLiga);
       return namedParameterJdbcTemplate.update(DELETE_QUERY, params);
    }

    @Override
    public int modificarEquipoLiga(InfoEquipoEn1LigaOutputDto infoEquipoEn1LigaOutputDto) {
        final String UPDATE_QUERY ="Update equipo_liga el " +
                "set el.puntos = :puntos " +
                ", el.partidos_jugados = :partidosJugados " +
                ", partidos_ganados = :partidosGanados " +
                ", el.partidos_perdidos = :partidosPerdidos " +
                ", el.partidos_empatados = :partidosEmpatados " +
                ", goles_a_favor = :golesFavor " +
                ", goles_en_contra = :golesContra " +
                "where (el.Cod_equipo = :codEquipo and el.Cod_liga = :codLiga) ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("puntos", infoEquipoEn1LigaOutputDto.getPuntos());
        params.addValue("partidosJugados", infoEquipoEn1LigaOutputDto.getPartidosJugados());
        params.addValue("partidosGanados", infoEquipoEn1LigaOutputDto.getPartidosGanados());
        params.addValue("partidosPerdidos", infoEquipoEn1LigaOutputDto.getPartidosPerdidos());
        params.addValue("partidosEmpatados", infoEquipoEn1LigaOutputDto.getPartidosEmpatados());
        params.addValue("golesFavor", infoEquipoEn1LigaOutputDto.getGolesFavor());
        params.addValue("golesContra", infoEquipoEn1LigaOutputDto.getGolesContra());
        params.addValue("codEquipo", infoEquipoEn1LigaOutputDto.getCodEquipo());
        params.addValue("codLiga", infoEquipoEn1LigaOutputDto.getCodLiga());
        return namedParameterJdbcTemplate.update(UPDATE_QUERY, params);
    }

    @Override
    public int insertar1EquipoEn1Liga(Integer codEquipo,Integer codLiga) {
        final String QUERY =  "insert  into equipo_liga " +
                "values ( " +
                " :codEquipo," +
                " :codLiga, " +
                " 0," +
                " 0," +
                " 0," +
                " 0," +
                " 0," +
                " 0," +
                " 0" +
                ")";
        MapSqlParameterSource param= new  MapSqlParameterSource();
        param.addValue("codEquipo",codEquipo);
        param.addValue("codLiga",codLiga);
        return namedParameterJdbcTemplate.update(QUERY,param);
    }
}
