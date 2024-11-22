package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Catalogo;
import com.prestamo.service.CatalogoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {


	@Autowired
	private CatalogoService catalogoService;
	

	@GetMapping("/listCatalogo")
    public ResponseEntity<List<Catalogo>> listarDescripcion() {
        List<Catalogo> descripcion = catalogoService.listaCatalogo();
        return ResponseEntity.ok(descripcion);
    }


	
}
