package com.tfc.tfc.LIGA.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "liga")
public class Liga implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Cod_liga", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codLiga;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Nacional", nullable = false)
    private Boolean nacional;
}
