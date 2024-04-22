package com.tfc.tfc.User.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

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

    private Integer cod_Rol;

}