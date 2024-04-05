package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "jugador")
public class Jugador {
    @Id
    @Column(name = "id_jugador", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellidos", length = 100)
    private String apellidos;

    @Column(name = "posicion", length = 100)
    private String posicion;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipos idEquipo;

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

    @Column(name = "imagen", length = 400)
    private String imagen;

    public Jugador(Integer id, String nombre, String apellidos, String posicion, LocalDate fechaNacimiento, Equipos idEquipo, Integer tarjetasAmarillas, Integer tarjetasRojas, Integer partidosJugados, Integer goles, Integer asistencias, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.idEquipo = idEquipo;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
        this.partidosJugados = partidosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.imagen = imagen;
    }
}