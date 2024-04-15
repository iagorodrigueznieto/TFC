package com.tfc.tfc.LIGA.Services;


import com.tfc.tfc.LIGA.Model.Entrenador;
import com.tfc.tfc.LIGA.Repository.EntrenadorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntrenadorService {


    private final EntrenadorRepository entrenadorRepository;


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




}
