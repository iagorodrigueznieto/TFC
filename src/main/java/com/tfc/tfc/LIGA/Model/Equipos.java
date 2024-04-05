package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "Partidos_Ganados", nullable = false)
    private Integer partidosGanados;

    @Column(name = "Partidos_Perdidos", nullable = false)
    private Integer partidosPerdidos;

    @Column(name = "Partidos_Empatados", nullable = false)
    private Integer partidosEmpatados;

    @Column(name = "imagen")
    private String imagen;

}
