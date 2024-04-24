package com.tfc.tfc.User.Services;

import com.tfc.tfc.User.Model.Usuario;
import com.tfc.tfc.User.Repository.UsuariosRepository;
import com.tfc.tfc.User.Repository.jdcb.JdbcUsuariosRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuariosRepository usuariosRepository;

    private final JdbcUsuariosRepositoryImpl jdbcUsuariosRepository;


    public List<Usuario> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuario getUsuariosById(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    public Usuario CreateUsuario(Usuario usuarios) {
        Usuario usuario= usuariosRepository.findById(usuarios.getLogin()).orElse(null);
        if(usuario==null){
            return usuariosRepository.save(usuarios);
        }
        else {
            return null;
        }
    }

    public void deleteUsuarios(String id) {
        usuariosRepository.deleteById(id);
    }

    @Transactional(transactionManager = "studentTransactionManager")
    public Usuario loginUsuario(String login, String contraseña) {
        return jdbcUsuariosRepository.login(login, contraseña);
    }


}
