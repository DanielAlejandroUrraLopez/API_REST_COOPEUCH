package cl.coopeuch.crudapibackend.enumerador.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.coopeuch.crudapibackend.dao.CrudapibackendDao;
import cl.coopeuch.crudapibackend.dto.TareaDto;
import cl.coopeuch.crudapibackend.enumerador.service.CrudapibackendService;

@Service
public class CrudapibackendServiceImp implements CrudapibackendService {
	private static final Logger log = LoggerFactory.getLogger(CrudapibackendServiceImp.class);

	@Autowired
	private CrudapibackendDao crudapibackendDao;
	

	/**
	 * Método para eliminacion de tarea por id
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@Override
	public String eliminacionDeTarea(int id) {
		log.info("eliminacionDeTarea: id "+ id );
		try {

			crudapibackendDao.deleteById(id);

			log.info("Tarea eliminado exitosamente!!!");
			return "Tarea eliminado exitosamente!!! ";

		} catch (Exception ex) {

			log.error("Error Al eliminar tarea!!!: "+ex.getMessage());
			return "Error Al eliminar tarea!!!";
		}
	}
	
	/**
	 * Método para agregar Tarea, se debe enviar un objeto de tipo tarea
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@Override
	public String agregarTarea(TareaDto tarea) {
		log.info("agregarTarea: Tarea "+ tarea );
		try {
			LocalDateTime fecha = LocalDateTime.now();
			
			tarea.setFechaCreacion(fecha);
			
			crudapibackendDao.save(tarea);
			
			log.info("Se agrego tarea exitosamente!!!");
			return "Se agrego tarea exitosamente!!!";

		} catch (Exception ex) {

			log.error("Error al agregar tarea!!!: "+ex.getMessage());
			return "Error al agregar tarea!!!";
		}

	}

	/**
	 * Método para listar todas las tareas
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@Override
	public List<TareaDto> listaTodasLasTareas() {
		log.info("listaTodasLasTareas");
		try {
			
			return (List<TareaDto>) ( crudapibackendDao.findAll());
			
			
		}catch(Exception ex) {
			
			log.error("Error al listar todas las tareas   !!!: "+ex.getMessage());
			return null;
		}
	}

	/**
	 * Método modificar tarea
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@Override
	public String modificarTarea(int id,TareaDto tarea) {
		log.info("modificarTarea: id: "+id+" TareaDto: "+tarea);
		
		try {
			
			TareaDto respuesta =  crudapibackendDao.findById(id).get();
			
			respuesta.setVigente(tarea.getVigente());
			respuesta.setDescripcion(tarea.getDescripcion());
			
			crudapibackendDao.save(respuesta);
			log.info("Se modifico tarea exitosamente!!!");
			return "Se modifico tarea exitosamente!!!";
			
		}catch(Exception ex) {
			log.error("Error al modificar tarea!!!: "+ex.getMessage());
			return ex.getMessage();
		}
	}
	
}
