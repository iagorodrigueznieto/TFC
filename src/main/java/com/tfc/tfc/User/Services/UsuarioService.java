package com.tfc.tfc.User.Services;

import com.tfc.tfc.User.Model.Usuarios;
import com.tfc.tfc.User.Repository.UsuariosRepository;
import com.tfc.tfc.User.Repository.jdcb.JdbcUsuariosRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuariosRepository usuariosRepository;

    private final JdbcUsuariosRepositoryImpl jdbcUsuariosRepository;


    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios getUsuariosById(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    public Usuarios CreateUsuario(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    public void deleteUsuarios(Integer id) {
        usuariosRepository.deleteById(id);
    }

@Transactional(transactionManager = "studentTransactionManager")
    public boolean loginUsuario(String login, String contraseña) {
        return jdbcUsuariosRepository.login(login, contraseña);
    }


}
