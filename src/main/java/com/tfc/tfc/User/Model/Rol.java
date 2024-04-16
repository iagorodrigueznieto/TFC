package com.tfc.tfc.User.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @Column(name = "cod_Rol", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "Descripcion", nullable = false, length = 100)
    private String descripcion;

}