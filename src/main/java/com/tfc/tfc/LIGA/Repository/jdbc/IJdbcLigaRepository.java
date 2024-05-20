package com.tfc.tfc.LIGA.Repository.jdbc;

import com.tfc.tfc.LIGA.Dto.InfoEquipoEn1LigaOutputDto;
import com.tfc.tfc.LIGA.Repository.LigaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
public interface IJdbcLigaRepository {
    int eliminar1Equipod1liga(Integer codEquipo,Integer codLiga);
    int modificarEquipoLiga(InfoEquipoEn1LigaOutputDto infoEquipoEn1LigaOutputDto);
    int insertar1EquipoEn1Liga(Integer codEquipo,Integer codLiga);


}
