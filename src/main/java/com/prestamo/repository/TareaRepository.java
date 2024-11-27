package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
	
	@Query("select r from Tarea r where r.descripcion like ?1")
	public abstract List<Tarea> listaTareaPorDescripcionLike(String descripcion);
	
	@Query("select r from Tarea r where (?1='-1' or r.categoria  = ?1) and (?2='-1' or r.prioridad = ?2 )")
	public abstract List<Tarea> listaTareaPorCategoriaPrioridad(String categoria, String prioridad);

}
