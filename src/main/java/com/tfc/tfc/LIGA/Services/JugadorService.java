package com.tfc.tfc.LIGA.Services;

import com.tfc.tfc.LIGA.Model.Jugador;
import com.tfc.tfc.LIGA.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;
    public List<Jugador> getAllPlayers(){
        return jugadorRepository.findAll();
    }

    public Jugador getJugadorById(Integer id){
        return jugadorRepository.findById(id).orElse(null);
    }
}
