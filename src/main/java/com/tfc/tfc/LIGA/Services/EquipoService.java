package com.tfc.tfc.LIGA.Services;

import com.tfc.tfc.LIGA.Dto.ClasificacionOutputDto;
import com.tfc.tfc.LIGA.Dto.InfoEquipoEn1LigaOutputDto;
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

    public Equipo guardarEquipos(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Integer cogerMaxId() {
       return jdbcEquipoReposiroty.cogerMaxId();
    }

    public List<Equipo> buscarPorNombre(String nombre) {
        return jdbcEquipoReposiroty.buscarEquiposPorNombre(nombre);
    }

    public void eliminarEquipo(Integer id) {
        equipoRepository.deleteById(id);
    }
    public Equipo actualizarEquipo(Equipo equipo) {
        Equipo equipo1=equipoRepository.findById(equipo.getIdEquipo()).orElse(null);
        if (equipo1!=null) {
            equipo1.setIdEquipo(equipo.getIdEquipo());
            equipo1.setNombreEquipo(equipo.getNombreEquipo());
            equipo1.setCiudad(equipo.getCiudad());
            equipo1.setIdEntrenador(equipo.getIdEntrenador());
            equipo1.setImagen(equipo.getImagen());
            equipo1.setPresidente(equipo.getPresidente());
            return equipoRepository.save(equipo1);
        }
        return null;
    }

    public InfoEquipoEn1LigaOutputDto recuperarInfoDe1EquipoEn1Liga(Integer codEquipo, Integer codLiga){
        return jdbcEquipoReposiroty.infoEquipo(codEquipo,codLiga);
    }
}
