package pc;

/*import static org.hamcrest.Matchers.*;
 import static org.hamcrest.Matchers.is;*/
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.InputStream;

import javax.sql.DataSource;

import org.dbunit.dataset.IDataSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
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

	private static final String DB_TEST_DB_SCHEME_SCRIPT = "data/test.db.scheme.with_data.script";
	//private static final String DB_TEST_DB_XML = "data/test.db.xml";
	//private static final String DB_TEST_DB_DTD = "data/test.db.dtd";
	
	private MockMvc mockMvc;
	
    @Autowired private MainService mainService; 	
	@Autowired private WebApplicationContext webApplicationContext;
	@Autowired private DataSource dataSource;

	@Before
	public void setUp() {
		
		  // read dataSet from dataSetURI
		ResourceDatabasePopulator tables = new ResourceDatabasePopulator();
		  tables.addScript(new ClassPathResource(DB_TEST_DB_SCHEME_SCRIPT));
		  //tables.addScript(new ClassPathResource(DB_TEST_DB_XML));

		  DatabasePopulatorUtils.execute(tables, dataSource);
		  
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
