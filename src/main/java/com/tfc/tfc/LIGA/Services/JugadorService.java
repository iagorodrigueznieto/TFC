package com.tfc.tfc.LIGA.Services;

import com.tfc.tfc.LIGA.Model.Jugador;
import com.tfc.tfc.LIGA.Repository.JugadorRepository;
import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class JugadorService {
    @Qualifier("IJdbcJugadorRepository")
    private final IJdbcJugadorRepository jugadorRepositoryImpl;

    private final JugadorRepository JugadorRepository;

    public List<Jugador> getAllPlayers(){
        return JugadorRepository.findAll();
    }

    public Jugador getJugadorById(Integer id){
        return JugadorRepository.findById(id).orElse(null);
    }

    public List<Jugador>getJugadoresByName(String nombre){
        return jugadorRepositoryImpl.buscarJugadorPorNombre(nombre);
    }

    public List<Jugador> getMaximosGoleadoresde1Liga(Integer codLiga){
        return jugadorRepositoryImpl.buscarMaximosGoleadoresDe1Liga(codLiga);
    }

}
