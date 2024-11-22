package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Catalogo;
import com.prestamo.repository.CatalogoRepository;

@Service
public class CatalogoServiceImpl implements CatalogoService{
	@Autowired
	private CatalogoRepository repository;

	@Override
	public List<Catalogo> listaCatalogo() {
		return repository.findAll();
	}
	
	
}
