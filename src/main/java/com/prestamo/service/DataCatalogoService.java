package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.DataCatalogo;

public interface DataCatalogoService {
	
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionIgual(String descripcion);
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionIgualActualiza(String descripcion, int idDataCatalogo);

	public abstract DataCatalogo insertarActualizaDataCatalogo (DataCatalogo obj);
	public abstract List<DataCatalogo> listaDataCatalogo(int idTipo);
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionLike(String descripcion);
	public abstract void eliminaDataCatalogo(int idDataCatalogo);
	public abstract List<DataCatalogo> listaDataCatalogo();
	
	//consulta
	public abstract List<DataCatalogo> consultaDataCatalogo(String descripcion, int estado, int idCatalogo);

}
