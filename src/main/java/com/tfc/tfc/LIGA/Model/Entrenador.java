package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entrenador")
public class Entrenador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_entrenador", nullable = false)
    private Integer idEntrenador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "fecha_de_nacimiento")
    private Date fechaDeNacimiento;

}
