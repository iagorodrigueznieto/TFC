package com.tfc.tfc.LIGA.Services;


import com.tfc.tfc.LIGA.Model.Entrenador;
import com.tfc.tfc.LIGA.Repository.EntrenadorRepository;

import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcEntrenadorRepository;
import com.tfc.tfc.LIGA.Repository.jdbc.Impl.JdbcEntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntrenadorService {


    private final EntrenadorRepository entrenadorRepository;


    private final JdbcEntrenadorRepository jdbcEntrenadorRepository;


    public List<Entrenador> findAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Entrenador findEntrenadorPorId(Integer codID) {
        return entrenadorRepository.findById(codID).orElse(null);
    }

    public Entrenador guardarEntrenador(Entrenador entrenador) {
       return entrenadorRepository.save(entrenador);
    }

    public void eliminarEntrenador(Entrenador entrenador) {
        entrenadorRepository.delete(entrenador);
    }

    public List<Entrenador> findEntrenadorWithNoTeam() {
        return jdbcEntrenadorRepository.findEntrenadorWithNoTeam();
    }





}
