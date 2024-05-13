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

    public List<Jugador> getAllPlayers() {
        return JugadorRepository.findAll();
    }

    public Jugador getJugadorById(Integer id) {
        return JugadorRepository.findById(id).orElse(null);
    }

    public List<Jugador> getJugadoresByName(String nombre) {
        return jugadorRepositoryImpl.buscarJugadorPorNombre(nombre);
    }

    public Jugador crearJugador(Jugador jugador) {
        return JugadorRepository.save(jugador);
    }

    public List<Jugador> getMaximosGoleadoresde1Liga(Integer codLiga) {
        return jugadorRepositoryImpl.buscarMaximosGoleadoresDe1Liga(codLiga);
    }


    public List<Jugador> getJugadoresDe1Equipo(Integer codEquipo) {
        return jugadorRepositoryImpl.buscarJugadoresDe1Equipo(codEquipo);
    }

    public void eliminarJugador(Integer id) {
        JugadorRepository.deleteById(id);
    }

    public void modificarJugador(Jugador jugador) {
        Jugador jugadorExistente = JugadorRepository.findById(jugador.getId_jugador()).orElse(null);
       if(jugadorExistente!=null){
           jugadorExistente.setId_jugador(jugador.getId_jugador());
           jugadorExistente.setNombre(jugador.getNombre());
           jugadorExistente.setAsistencias(jugador.getAsistencias());
           jugadorExistente.setGoles(jugador.getGoles());
           jugadorExistente.setTarjetasAmarillas(jugador.getTarjetasAmarillas());
           jugadorExistente.setTarjetasRojas(jugador.getTarjetasRojas());
           jugadorExistente.setFechaNacimiento(jugador.getFechaNacimiento());
           jugadorExistente.setCod_Posicion(jugador.getCod_Posicion());
           JugadorRepository.save(jugadorExistente);
        }
       }

        public List<Jugador> getJugadoresDe1EquipoEn1Posicion(Integer codEquipo,Integer codLiga) {
            return jugadorRepositoryImpl.buscarJugadoresDe1EquipoDe1Posicion(codEquipo,codLiga);

        }

    }

