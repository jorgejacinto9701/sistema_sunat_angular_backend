package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prestamo.entity.Opcion;
import com.prestamo.entity.Rol;
import com.prestamo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("Select x from Usuario x where x.login = :#{#usu.login} and x.password = :#{#usu.password}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);
	
	@Query("Select p from Opcion p, RolHasOpcion pr, Rol r, UsuarioHasRol u where  p.idOpcion = pr.opcion.idOpcion and pr.rol.idRol = r.idRol and r.idRol = u.rol.idRol and u.usuario.idUsuario = ?1 ")
	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	@Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.idUsuario = ?1 ")
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	
	public abstract Usuario findByLogin(String login);
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 2 order by r.apellidos desc ")
	public abstract List<Usuario> listaJefePrestamistaTotales();
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 3 and r.usuarioSuperior =?1 order by r.apellidos desc ")
	public abstract List<Usuario> listaPrestamistaDeUnJefe(int idUsuario);
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 and r.usuarioSuperior =?1 order by r.apellidos desc ")
	public abstract List<Usuario> listaPrestamistariosDeUnPrestamista(int idUsuario);
  @Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 order by r.apellidos desc ")
	public abstract List<Usuario> listaPrestatarios();
  /*consulta filtro*/
  	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 and r.nombres like %?1%")
  	public abstract List<Usuario> listaPrestatariosPorNombreLike(String nombre);
  
  	
  	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 and r.nombres like ?1 and r.estado = ?2 and r.dni = ?3 and r.login like ?4")
  	
  	public abstract List<Usuario> listaConsultaCompleja(String nombre, int estado, int dni, String login);
  	
  	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 and r.dni = ?1")
	public abstract List<Usuario> listaEjemploPorDniIgual(int dni);
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 and r.login = ?1")
	public abstract List<Usuario> listaPrestatarioPorLoginIgual(String login);



}

