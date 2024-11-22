package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.DataCatalogo;
import com.prestamo.service.DataCatalogoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/crudDataCatalogo")
@CrossOrigin (AppSettings.URL_CROSS_ORIGIN)
public class DataCatalogoCrudController {
	
	@Autowired
	private DataCatalogoService DataCatalogoService;
	
	@GetMapping("/listaDataCatalogoPorNombreLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaDataCatalogoPorNombreLike(@PathVariable("var") String descripcion){
		List<DataCatalogo> lstSalida = null;
		if (descripcion.equals("todos")) {
			lstSalida =DataCatalogoService.listaDataCatalogo();
		}else {
			lstSalida =DataCatalogoService.listaDataCatalogoPorDescripcionLike(descripcion +  "%");
		}
		return ResponseEntity.ok(lstSalida);
	}
	@PostMapping("/registraDataCatalogo")
	@ResponseBody
	public ResponseEntity<?> insertaDataCatalogo(@RequestBody DataCatalogo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdDataCatalogo(0);
			obj.setFechaActualizacion(new Date());
			obj.setFechaRegistro(new Date());
			
			DataCatalogo objSalida = DataCatalogoService.insertarActualizaDataCatalogo(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + " Ejemplo de ID ==> " + obj.getIdDataCatalogo() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaDataCatalogo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaDataCatalogo(@RequestBody DataCatalogo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			obj.setFechaActualizacion(new Date());

			DataCatalogo objSalida = DataCatalogoService.insertarActualizaDataCatalogo(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Ejemplo de ID ==> " + obj.getIdDataCatalogo() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/eliminaDataCatalogo/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaDataCatalogo(@PathVariable("id") int idDataCatalogo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			DataCatalogoService.eliminaDataCatalogo(idDataCatalogo);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Ejemplo de ID ==> " + idDataCatalogo + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/validaDescripcionActualiza")
	public String validaDescripcion(String descripcion,
									int idDataCatalogo) {
		 List<DataCatalogo> lstSalida =DataCatalogoService.listaDataCatalogoPorDescripcionIgualActualiza(descripcion, idDataCatalogo);
		 if (lstSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
			
	}
}
