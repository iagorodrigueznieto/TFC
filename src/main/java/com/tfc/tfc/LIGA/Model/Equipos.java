package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "equipos")
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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


}
