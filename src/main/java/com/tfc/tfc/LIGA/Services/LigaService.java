package com.tfc.tfc.LIGA.Services;

import com.tfc.tfc.LIGA.Model.Liga;
import com.tfc.tfc.LIGA.Repository.LigaRepository;
import com.tfc.tfc.LIGA.Repository.jdbc.IJdbcLigaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LigaService {

    private final LigaRepository ligaRepository;


    @Qualifier("IJdbcLigaRepository")
    private final IJdbcLigaRepository jdbcLigaRepository;



    public List<Liga> getAllLigas() {
        return ligaRepository.findAll();
    }
    public Liga getLigaById(int id) {
        return ligaRepository.findById(id).orElse(null);
    }



}
