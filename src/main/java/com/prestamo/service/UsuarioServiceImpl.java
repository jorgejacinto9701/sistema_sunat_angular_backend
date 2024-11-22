package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Opcion;
import com.prestamo.entity.Rol;
import com.prestamo.entity.Usuario;
import com.prestamo.entity.UsuarioHasRol;
import com.prestamo.entity.UsuarioHasRolPK;
import com.prestamo.repository.RolRepository;
import com.prestamo.repository.UsuarioRepository;
import com.prestamo.repository.UsuarioTieneRolRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	 @Autowired
	 private RolRepository rolRepository; 

	 @Autowired
	 private UsuarioTieneRolRepository usuarioHasRolRepository;
	
	@Override
	public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
		return repository.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		return repository.traerRolesDeUsuario(idUsuario);
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public List<Usuario> listaJefePrestamistaTotales() {
		return repository.listaJefePrestamistaTotales();
	}

	@Override
	public List<Usuario> listaPrestamistaDeUnJefe(int idUsuario) {
		return repository.listaPrestamistaDeUnJefe(idUsuario);
	}

	@Override
	public List<Usuario> listaPrestamistariosDeUnPrestamista(int idUsuario) {
		return repository.listaPrestamistariosDeUnPrestamista(idUsuario);
	}
	@Override 
	public List<Usuario> listaPrestatario(){
		return repository.listaPrestatarios();
	}
	@Override
	public Usuario registrarUsuario(Usuario u) {
		
		Usuario usuarioGuardado = repository.save(u);
		
        Rol rol = rolRepository.findById(4).orElse(null);
        if (rol != null) {
            UsuarioHasRolPK usuarioHasRolPK = new UsuarioHasRolPK();
            usuarioHasRolPK.setIdUsuario(usuarioGuardado.getIdUsuario());
            usuarioHasRolPK.setIdRol(rol.getIdRol());

            UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
            usuarioHasRol.setUsuarioHasRolPk(usuarioHasRolPK);
            usuarioHasRol.setUsuario(usuarioGuardado);
            usuarioHasRol.setRol(rol);

            usuarioHasRolRepository.save(usuarioHasRol);
        } else {
            throw new RuntimeException("El rol con ID 4 no existe.");
        }
		return usuarioGuardado;
	}
	@Override
	public Usuario actualizarUsuario(Usuario u) {
		
		Usuario usuarioGuardado = repository.save(u);
		
        Rol rol = rolRepository.findById(4).orElse(null);
        if (rol != null) {
            UsuarioHasRolPK usuarioHasRolPK = new UsuarioHasRolPK();
            usuarioHasRolPK.setIdUsuario(usuarioGuardado.getIdUsuario());
            usuarioHasRolPK.setIdRol(rol.getIdRol());

            UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
            usuarioHasRol.setUsuarioHasRolPk(usuarioHasRolPK);
            usuarioHasRol.setUsuario(usuarioGuardado);
            usuarioHasRol.setRol(rol);

            usuarioHasRolRepository.save(usuarioHasRol);
        } else {
            throw new RuntimeException("El rol con ID 4 no existe.");
        }
		return usuarioGuardado;
	}

	@Override
	public List<Usuario> listaPrestatariosPorNombreLike(String nombre) {
		return repository.listaPrestatariosPorNombreLike(nombre);
	}
	@Override
	public void eliminaPrestatario(int idUsuario) {
		repository.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> listaConsultaCompleja(String nombre, int  estado, int dni, String login) {
		return repository.listaConsultaCompleja(nombre, estado, dni, login);
	}

	@Override
	public List<Usuario> listaEjemploPorDniIgual(int dni) {
		return repository.listaEjemploPorDniIgual(dni);
	}
	@Override
	public List<Usuario> listaPrestatarioPorLoginIgual(String login) {
		return repository.listaPrestatarioPorLoginIgual(login);
	}

	@Override
	public List<Usuario> listaPrestatarioPorDniIgualActualiza(int dni, int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}




}
