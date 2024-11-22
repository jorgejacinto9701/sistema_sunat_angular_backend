package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.DataCatalogo;

public interface DataCatalogoRepository extends JpaRepository<DataCatalogo, Integer>{
	
	//CRUD
	@Query("Select r from DataCatalogo r where r.catalogo.idCatalogo =  ?1 order by descripcion asc")
	public abstract List<DataCatalogo> listaDataCatalogo(int idTipo);
	
	@Query("select r from DataCatalogo r where r.descripcion = ?1")
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionIgual(String descripcion);
	
	@Query("select r from DataCatalogo r where r.descripcion like ?1")
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionLike(String descripcion);
	
	@Query("select r from DataCatalogo r where r.descripcion = ?1 and r.idDataCatalogo != ?2 ")
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionIgualActualiza(String descripcion, int idDataCatalogo);
	
	//consulta
	
	@Query ("Select r from DataCatalogo r where r.descripcion LIKE ?1 AND r.estado=?2 AND (?3= -1 or r.catalogo.idCatalogo=?3)")
	List<DataCatalogo> consultaDataCatalogo (String descripcion, int estado, int idCatalogo);
	
}
