package cl.coopeuch.crudapibackend.enumerador.service;

import java.util.List;

import cl.coopeuch.crudapibackend.dto.TareaDto;

public interface CrudapibackendService {

	String eliminacionDeTarea(int id);
	
	String agregarTarea(TareaDto tarea);
	
	List<TareaDto> listaTodasLasTareas();
	
	String modificarTarea(int id,TareaDto tarea);
	
}
