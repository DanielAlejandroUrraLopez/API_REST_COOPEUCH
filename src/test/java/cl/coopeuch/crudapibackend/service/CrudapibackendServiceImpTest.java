package cl.coopeuch.crudapibackend.service;

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

import cl.coopeuch.crudapibackend.dao.CrudapibackendDao;
import cl.coopeuch.crudapibackend.dto.TareaDto;
import cl.coopeuch.crudapibackend.enumerador.service.impl.CrudapibackendServiceImp;

@ExtendWith(MockitoExtension.class)
public class CrudapibackendServiceImpTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private CrudapibackendServiceImp crudapibackendServiceImp;
	
	@Mock
	private CrudapibackendDao crudapibackendDao;
	
	@BeforeEach
    public void config() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(crudapibackendServiceImp).build();
    }
	
	@Test
	public void eliminacionDeTareaTest() {
				
		String r = crudapibackendServiceImp.eliminacionDeTarea(1);			
		assertNotNull(r);
	}
	@Test
	public void agregarTareaTest() {
		TareaDto t = new TareaDto();
		t.setVigente(true);
				
		String r = crudapibackendServiceImp.agregarTarea(t);			
		assertNotNull(r);
	}
	
	@Test
	public void listaTodasLasTareasTest() {
		TareaDto t = new TareaDto();
		t.setVigente(true);
		
		List<TareaDto> tl = new ArrayList<TareaDto>();
		tl.add(t);
				
		List<TareaDto>  r = crudapibackendServiceImp.listaTodasLasTareas();			
		assertNotNull(r);
		
	}
	
	@Test
	public void modificarTareaTest() {
		TareaDto t = new TareaDto();
		t.setVigente(true);
		
		String r = crudapibackendServiceImp.modificarTarea(1,t);			
		assertNotNull(r);
	}

}
