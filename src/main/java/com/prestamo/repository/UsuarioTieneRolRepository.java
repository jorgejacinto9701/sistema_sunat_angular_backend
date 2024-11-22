package com.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prestamo.entity.UsuarioHasRol;
import com.prestamo.entity.UsuarioHasRolPK;

public interface UsuarioTieneRolRepository extends JpaRepository<UsuarioHasRol, UsuarioHasRolPK>{

	
}
