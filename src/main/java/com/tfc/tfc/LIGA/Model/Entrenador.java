package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenador", nullable = false)
    private Integer idEntrenador;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Size(max = 100)
    @Column(name = "apellido", length = 100)
    private String apellido;

    @Size(max = 100)
    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    @Size(max = 255)
    @Column(name = "fecha_de_nacimiento")
    private String fechaDeNacimiento;

}