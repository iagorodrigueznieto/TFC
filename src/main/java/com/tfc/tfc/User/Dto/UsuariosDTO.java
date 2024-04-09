package com.tfc.tfc.User.Dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UsuariosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idUser;

    private String userName;

    private String password;

    private String image;

    private String mail;

}
