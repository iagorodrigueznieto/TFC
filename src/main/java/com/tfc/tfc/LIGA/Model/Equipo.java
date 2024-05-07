package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "equipos")
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;

    @Column(name = "nombre_equipo")
    private String nombreEquipo;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "id_entrenador", nullable = false)
    private Integer idEntrenador;

    @Column(name = "imagen")
    private String imagen;


    @Column(name = "presidente")
    private String presidente;

}
