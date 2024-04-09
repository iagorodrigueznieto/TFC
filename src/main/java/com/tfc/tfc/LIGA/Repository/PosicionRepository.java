package com.tfc.tfc.LIGA.Repository;

import com.tfc.tfc.LIGA.Model.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Integer> {
}
