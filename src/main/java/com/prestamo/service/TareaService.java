package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Tarea;

public interface TareaService {

	
	public abstract Tarea insertarActualizaTarea (Tarea obj);
	public abstract List<Tarea> listaTareaPorDescripcionLike(String descripcion);
	public abstract void eliminaTarea(int idTarea);
	public abstract List<Tarea> listaTarea();
	public abstract List<Tarea> listaTareaPorCategoriaPrioridad(String categoria,String  prioridad);
	
}
