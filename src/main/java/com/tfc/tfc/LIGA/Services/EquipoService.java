package com.tfc.tfc.LIGA.Services;

import com.tfc.tfc.LIGA.Dto.ClasificacionOutputDto;
import com.tfc.tfc.LIGA.Model.Equipo;
import com.tfc.tfc.LIGA.Repository.EquipoRepository;
import com.tfc.tfc.LIGA.Repository.jdbc.Impl.JdbcEquipoRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;

    private final JdbcEquipoRepositoryImpl jdbcEquipoReposiroty;



    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public List<ClasificacionOutputDto> getEquiposByLiga(Integer codLiga) {
        return jdbcEquipoReposiroty.clasificacionEquipos(codLiga);
    }


}
