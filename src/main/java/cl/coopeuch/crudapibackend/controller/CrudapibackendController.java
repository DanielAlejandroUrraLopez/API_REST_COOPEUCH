package cl.coopeuch.crudapibackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.coopeuch.crudapibackend.dto.TareaDto;
import cl.coopeuch.crudapibackend.enumerador.service.CrudapibackendService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/crudapibackend")
public class CrudapibackendController {
	
	private static final Logger log = LoggerFactory.getLogger(CrudapibackendController.class);

	@Autowired
	private CrudapibackendService crudapibackendService;	
	
	/**
	 * Método para eliminar de tarea por id
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@ApiOperation(value = "eliminacion de tarea por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se elimino tarea con exito"),@ApiResponse(code = 404, message = "Error") })
	@DeleteMapping(value ="eliminacionDeTarea/{id:.*}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminacionDeTarea(@PathVariable(required = true) int id) {	
		log.info("eliminacionDeTarea: id "+ id );
		return ResponseEntity.status(HttpStatus.OK).body(crudapibackendService.eliminacionDeTarea(id));
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
	@ApiOperation(value = "Agregar Tarea")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se Agregar Tarea"),@ApiResponse(code = 404, message = "Error") })
	@PostMapping(value ="agregarTarea{tarea:.*}")
	public ResponseEntity<String> agregarTarea(@Validated @RequestBody TareaDto tarea) {
		log.info("agregarTarea: tarea "+ tarea );
		return ResponseEntity.status(HttpStatus.OK).body(crudapibackendService.agregarTarea(tarea));
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
	@ApiOperation(value = "Listar todas las tareas")
	@ApiResponses({ @ApiResponse(code = 200, message = "Lista todas las tareas"),@ApiResponse(code = 404, message = "Error") })
	@GetMapping(value ="listaTodasLasTareas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TareaDto>> listaTodasLasTareas() {		
		log.info("listaTodasLasTareas" );
		return ResponseEntity.status(HttpStatus.OK).body(crudapibackendService.listaTodasLasTareas());
	}
	
	/**
	 * Método para modificar Tarea
	 * 
	 * <li>historial de versiones:</li>
	 * <ul>
	 * <li>Autor : Daniel Alejandro Urra López</li>
	 * <li>Versión: 1.0.0</li>
	 * <li>Descripción : Creación del método</li>
	 * </ul>
	 ***/
	@ApiOperation(value = "modificar tarea")
	@ApiResponses({ @ApiResponse(code = 200, message = "modificar tarea"),@ApiResponse(code = 404, message = "Error") })
	@PutMapping(value ="modificarTarea/{id:.*}/{tarea:.*}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> modificarTarea(@PathVariable(required = true) int id,@Validated @RequestBody TareaDto tarea) {
		log.info("modificarTarea: id: "+ id +" TareaDto: "+ tarea);
		return ResponseEntity.status(HttpStatus.OK).body(crudapibackendService.modificarTarea(id,tarea));
	}
	
}
