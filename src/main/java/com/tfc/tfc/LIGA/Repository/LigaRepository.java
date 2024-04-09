package com.tfc.tfc.LIGA.Repository;


import com.tfc.tfc.LIGA.Model.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigaRepository extends JpaRepository<Liga, Integer> {
}
