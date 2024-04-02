package com.tfc.tfc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagene {
    @Id
    @Column(name = "imagenes", nullable = false, length = 100)
    private String imagenes;

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    //TODO [JPA Buddy] generate columns from DB
}