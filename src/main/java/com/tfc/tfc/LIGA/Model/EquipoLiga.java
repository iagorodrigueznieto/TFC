package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "equipo_liga")
public class EquipoLiga implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Cod_equipo", nullable = false)
    private Integer codEquipo;

    @Id
    @Column(name = "Cod_liga", nullable = false)
    private Integer codLiga;

}
