package com.tfc.tfc.User.Services;

import com.tfc.tfc.User.Model.Usuarios;
import com.tfc.tfc.User.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuarios> getAllUsuarios(){
        return usuariosRepository.findAll();
    }
    public Usuarios getUsuariosById(Long id){
        return usuariosRepository.findById(id).orElse(null);
    }

    public Usuarios CreateUsuario(Usuarios usuarios){
        return usuariosRepository.save(usuarios);
    }

    public void deleteUsuarios(Long id){
        usuariosRepository.deleteById(id);
    }


}
