package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "posicion")
public class Posicion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Cod_posicion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPosicion;

    @Column(name = "Nombre")
    private String nombre;

}
