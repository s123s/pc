package pc;

/*import static org.hamcrest.Matchers.*;
 import static org.hamcrest.Matchers.is;*/
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import pc.service.MainService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:test-mvc-dispatcher-servlet.xml",
		"classpath:spring/test-root-context.xml",
		"classpath:spring/test-application-security.xml" 
		})

@WebAppConfiguration("classpath:test-web.xml")
public class MVCTest {

	private static final String DB_TABLES_DATA_FULL_FILE_XML = "../.db/tables_data_full.xml";
	
	private MockMvc mockMvc;
	
    @Autowired private MainService mainService; 	
	@Autowired private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		// We have to reset our mock between tests because the mock objects
		// are managed by the Spring container. If we would not reset them,
		// stubbing and verified behavior would "leak" from one test to another.
		//mainService = Mockito.mock(MainService.class);

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void aaa() throws Exception {
		mockMvc.perform(get("/computer")).andExpect(status().isOk())
		.andExpect(view().name("computer"));

//		Возвращается ВСЕГДА errorPage при ошибке
		mockMvc.perform(get("/NoPageSASADS", 1L)).andExpect(status().isOk())
		.andExpect(forwardedUrl("default"));

		//Есть Mock-объект(mainService в (frontend)/test-root-context.xml) 
		verify(mainService, atLeast(1)).getComputerDao();
		
		
/*		mockMvc.perform(get("/todo1/{id}", 1L)).andExpect(status().isNotFound())
				.andExpect(view().name("error/404"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/error/404.jsp"));
		verifyZeroInteractions(mainService);*/
	}

	/*@Test
	@DatabaseSetup(DB_TABLES_DATA_FULL_FILE_XML)
	public void testDatabase() {
		
	}
*/
	
}
