package com.tfc.tfc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @Column(name = "id_equipo", nullable = false)
    private Integer id;

    @Column(name = "nombre_equipo", length = 100)
    private String nombreEquipo;

    @Column(name = "ciudad", length = 100)
    private String ciudad;

    @Column(name = "Partidos_Ganados", nullable = false)
    private Integer partidosGanados;

    @Column(name = "Partidos_Perdidos", nullable = false)
    private Integer partidosPerdidos;

    @Column(name = "Partidos_Empatados", nullable = false)
    private Integer partidosEmpatados;

    @Column(name = "imagen", length = 300)
    private String imagen;

    private Integer PartidosJugados=partidosEmpatados+partidosGanados+partidosPerdidos;
}