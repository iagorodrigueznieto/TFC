package com.tfc.tfc.User.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "image")
    private String image;

    @Column(name = "Mail", nullable = false)
    private String mail;

}
