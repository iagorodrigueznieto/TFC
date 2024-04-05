package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "entrenador")
public class Entrenador {
    @Id
    @Column(name = "id_entrenador", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido", length = 100)
    private String apellido;

    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    @Column(name = "fecha_de_nacimiento")
    private LocalDate fechaDeNacimiento;

    public Entrenador() {

    }
}