package com.tfc.tfc.LIGA.Services;


import com.tfc.tfc.LIGA.Model.Entrenador;
import com.tfc.tfc.LIGA.Repository.EntrenadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public List<Entrenador> findAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Entrenador findEntrenadorPorId(Integer codID) {
        return entrenadorRepository.findById(codID).orElse(null);
    }


    public Entrenador GuardarEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }
    public void EliminarEntrenador(Entrenador entrenador){
        entrenadorRepository.delete(entrenador);
    }


}
