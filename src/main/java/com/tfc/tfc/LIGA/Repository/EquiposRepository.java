package com.tfc.tfc.LIGA.Repository;

import com.tfc.tfc.LIGA.Model.Equipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquiposRepository extends JpaRepository<Equipos, Integer> {
}
