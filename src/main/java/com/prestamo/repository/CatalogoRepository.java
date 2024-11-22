package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Catalogo;

public interface CatalogoRepository extends JpaRepository<Catalogo, Integer>{
	@Query("select c.descripcion from Catalogo c")
	public abstract List<Catalogo> listaCatalogo();
}
