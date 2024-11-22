package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Opcion;
import com.prestamo.entity.Rol;
import com.prestamo.entity.Usuario;

public interface UsuarioService {

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);

	public abstract List<Usuario> listaJefePrestamistaTotales();

	public abstract List<Usuario> listaPrestamistaDeUnJefe(int idUsuario);

	public abstract List<Usuario> listaPrestamistariosDeUnPrestamista(int idUsuario);

	public abstract List<Usuario> listaPrestatario();

	public abstract Usuario registrarUsuario(Usuario u);
	public abstract Usuario actualizarUsuario(Usuario u);

	
  	public abstract List<Usuario> listaPrestatariosPorNombreLike(String nombre);
	public abstract void eliminaPrestatario(int idUsuario);
	public abstract List<Usuario> listaConsultaCompleja(String nombre, int  estado,  int dni, String login);
	
	public abstract List<Usuario> listaEjemploPorDniIgual(int dni);
	public abstract List<Usuario> listaPrestatarioPorLoginIgual(String login);

	public abstract List<Usuario> listaPrestatarioPorDniIgualActualiza(int dni, int idUsuario);


	

}
