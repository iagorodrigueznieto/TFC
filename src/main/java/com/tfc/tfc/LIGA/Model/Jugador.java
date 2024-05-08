package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "jugador")
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador", nullable = false)
    private Integer idJugador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;

    @Column(name = "Tarjetas_Amarillas", nullable = false)
    private Integer tarjetasAmarillas;

    @Column(name = "Tarjetas_Rojas", nullable = false)
    private Integer tarjetasRojas;

    @Column(name = "Partidos_Jugados", nullable = false)
    private Integer partidosJugados;

    @Column(name = "Goles", nullable = false)
    private Integer goles;

    @Column(name = "Asistencias", nullable = false)
    private Integer asistencias;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "Cod_Posicion", nullable = false)
    private Integer codPosicion;

}
