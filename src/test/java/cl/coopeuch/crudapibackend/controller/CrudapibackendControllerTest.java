package cl.coopeuch.crudapibackend.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cl.coopeuch.crudapibackend.dto.TareaDto;
import cl.coopeuch.crudapibackend.enumerador.service.CrudapibackendService;

@ExtendWith(MockitoExtension.class)
public class CrudapibackendControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private CrudapibackendController crudapibackendController;
	
	@Mock
	private CrudapibackendService crudapibackendService;
	
	@BeforeEach
    public void config() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(crudapibackendController).build();
    }
	
	@Test
	public void eliminacionDeTareaTest() {
		
		doReturn("ok").when(crudapibackendService).eliminacionDeTarea(1);		
		ResponseEntity<String> r = crudapibackendController.eliminacionDeTarea(1);		
		
		assertNotNull(r);
	}
	
	@Test
	public void agregarTareaTest() {
		TareaDto t = new TareaDto();
		t.setVigente(true);
		
		doReturn("ok").when(crudapibackendService).agregarTarea(t);		
		ResponseEntity<String> r = crudapibackendController.agregarTarea(t);		
		
		assertNotNull(r);
		
	}
	
	@Test
	public void listaTodasLasTareasTest() {	
		
		TareaDto t = new TareaDto();
		t.setVigente(true);
		
		List<TareaDto> tl = new ArrayList<>();
		tl.add(t);
		
		doReturn(tl).when(crudapibackendService).listaTodasLasTareas();		
		ResponseEntity<List<TareaDto>> r = crudapibackendController.listaTodasLasTareas();		
		
		assertNotNull(r);
	}
	
	@Test
	public void modificarTareaTest() {
		
		TareaDto t = new TareaDto();
		t.setVigente(true);
		
		doReturn("ok").when(crudapibackendService).modificarTarea(1,t);		
		ResponseEntity<String> r = crudapibackendController.modificarTarea(1,t);		
		
		assertNotNull(r);
		
	}
	
	

}
