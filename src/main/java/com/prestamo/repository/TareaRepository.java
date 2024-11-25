package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
	
	@Query("select r from Tarea r where r.descripcion like ?1")
	public abstract List<Tarea> listaTareaPorDescripcionLike(String descripcion);


}
