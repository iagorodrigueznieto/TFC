package com.tfc.tfc.User.Repository;

import com.tfc.tfc.User.Modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}