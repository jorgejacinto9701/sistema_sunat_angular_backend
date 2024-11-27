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

import com.prestamo.entity.Tarea;
import com.prestamo.service.TareaService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/crudTarea")
@CrossOrigin (AppSettings.URL_CROSS_ORIGIN)
public class TareaCrudController {
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping("/listaTareaPorNombreLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaTareaPorNombreLike(@PathVariable("var") String descripcion){
		List<Tarea> lstSalida = null;
		if (descripcion.equals("todos")) {
			lstSalida =tareaService.listaTarea();
		}else {
			lstSalida =tareaService.listaTareaPorDescripcionLike(descripcion +  "%");
		}
		return ResponseEntity.ok(lstSalida);
	}
	@PostMapping("/registraTarea")
	@ResponseBody
	public ResponseEntity<?> insertaTarea(@RequestBody Tarea obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdTarea(0);
			obj.setFechaRegistro(new Date());
			
			Tarea objSalida = tareaService.insertarActualizaTarea(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + " Ejemplo de ID ==> " + obj.getIdTarea() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaTarea")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaTarea(@RequestBody Tarea obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Tarea objSalida = tareaService.insertarActualizaTarea(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Ejemplo de ID ==> " + obj.getIdTarea() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/eliminaTarea/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaTarea(@PathVariable("id") int idTarea) {
		Map<String, Object> salida = new HashMap<>();
		try {
			tareaService.eliminaTarea(idTarea);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Ejemplo de ID ==> " + idTarea + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	
	@GetMapping("/listaTareaPorCategoriaPrioridad/{categoria}/{prioridad}")
	@ResponseBody
	public ResponseEntity<?> listaTareaPorCategoriaPrioridad(@PathVariable String categoria, @PathVariable String prioridad){
		List<Tarea> lstSalida = tareaService.listaTareaPorCategoriaPrioridad(categoria, prioridad);
		return ResponseEntity.ok(lstSalida);
	}
	
	
}
