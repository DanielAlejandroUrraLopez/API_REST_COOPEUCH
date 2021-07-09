

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import cl.coopeuch.crudapibackend.CrudapibackendApplication;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, 
classes = {
		CrudapibackendApplication.class
		
	}
)
public class ConfigurateTest {

	@Test
	public void context() {
		
	}
}