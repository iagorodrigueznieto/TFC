package com.tfc.tfc.LIGA.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class ClasificacionOutputDto {

    private Integer idEquipo;

    private String nombreEquipo;

    private String ciudad;

    private Integer idEntrenador;

    private String imagen;

    public Integer puntos;

}
