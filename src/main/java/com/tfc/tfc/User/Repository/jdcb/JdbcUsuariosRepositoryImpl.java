package com.tfc.tfc.User.Repository.jdcb;

import com.tfc.tfc.User.Model.Usuarios;
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
    public boolean login(String username, String password) {

        String sql = "select * from usuarios.usuarios where login = :username and contraseña = :password";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", username);
        params.addValue("password", password);
        List<Usuarios> lista = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Usuarios.class));
        if (lista.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
