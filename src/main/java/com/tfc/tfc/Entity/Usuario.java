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
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Column(name = "nombre_usuario", nullable = false, length = 100)
    private String nombreUsuario;

    @Column(name = "`contraseña`", nullable = false, length = 100)
    private String contraseña;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

}