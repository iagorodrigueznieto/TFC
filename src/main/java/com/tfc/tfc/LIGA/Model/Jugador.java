package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador", nullable = false)
    private Integer id_jugador;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Size(max = 255)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    @ColumnDefault("3333")
    @JoinColumn(name = "id_equipo")
    private Integer id_equipo;

    @NotNull
    @Column(name = "Tarjetas_Amarillas", nullable = false)
    private Integer tarjetasAmarillas;

    @NotNull
    @Column(name = "Tarjetas_Rojas", nullable = false)
    private Integer tarjetasRojas;

    @NotNull
    @Column(name = "Partidos_Jugados", nullable = false)
    private Integer partidosJugados;

    @NotNull
    @Column(name = "Goles", nullable = false)
    private Integer goles;

    @NotNull
    @Column(name = "Asistencias", nullable = false)
    private Integer asistencias;

    @Size(max = 400)
    @Column(name = "imagen", length = 400)
    private String imagen;

    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Cod_Posicion", nullable = false)
    private Integer Cod_Posicion;

}