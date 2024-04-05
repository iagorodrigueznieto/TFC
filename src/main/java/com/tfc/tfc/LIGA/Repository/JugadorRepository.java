package com.tfc.tfc.LIGA.Repository;

import com.tfc.tfc.LIGA.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
}
