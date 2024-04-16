package com.tfc.tfc.User.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "login", nullable = false, length = 100)
    private String login;

    @Size(max = 100)
    @NotNull
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Size(max = 100)
    @NotNull
    @Column(name = "`contraseña`", nullable = false, length = 100)
    private String contraseña;

    @NotNull
    @JoinColumn(name = "cod_Rol", nullable = false)
    private Integer codRol;

}