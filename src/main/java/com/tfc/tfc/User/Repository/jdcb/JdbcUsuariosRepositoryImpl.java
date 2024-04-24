package com.tfc.tfc.User.Repository.jdcb;

import com.tfc.tfc.User.Model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcUsuariosRepositoryImpl {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Transactional(transactionManager = "studentTransactionManager")
    public Usuario login(String username, String password) {

        String sql = "select * from usuarios.usuarios where BINARY login = :username and BINARY contraseña = :password";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", username);
        params.addValue("password", password);
        List<Usuario> lista = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Usuario.class));
       if (lista.isEmpty()){
           return null;
       }
        return lista.get(0);
    }
}
