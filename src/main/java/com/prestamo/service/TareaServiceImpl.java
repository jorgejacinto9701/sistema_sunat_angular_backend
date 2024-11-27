package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Tarea;
import com.prestamo.repository.TareaRepository;

@Service
public class TareaServiceImpl implements TareaService{

	@Autowired
	private TareaRepository repository;
	
	
	@Override
	public Tarea insertarActualizaTarea(Tarea obj) {
		return repository.save(obj);
	}

	@Override
	public List<Tarea> listaTareaPorDescripcionLike(String descripcion) {
		return repository.listaTareaPorDescripcionLike(descripcion);
	}

	@Override
	public void eliminaTarea(int idTarea) {
		repository.deleteById(idTarea);
	}

	@Override
	public List<Tarea> listaTarea() {
		return repository.findAll();
	}

	@Override
	public List<Tarea> listaTareaPorCategoriaPrioridad(String categoria, String prioridad) {
		return repository.listaTareaPorCategoriaPrioridad(categoria, prioridad);
	}

}
