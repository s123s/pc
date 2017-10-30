package pc;

/*import static org.hamcrest.Matchers.*;
 import static org.hamcrest.Matchers.is;*/
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.InputStream;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pc.service.MainService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:test-mvc-dispatcher-servlet.xml",
		"classpath:spring/test-root-context.xml",
		"classpath:spring/test-application-security.xml" })
// @ComponentScan(basePackages = { "pc.controller", "pc.security.controller",
// "pc.dao.hibernate", "pc.service" } )
@WebAppConfiguration("classpath:test-web.xml")
public class MVCTest {

	private static final String DB_TEST_DB_SCHEME_SCRIPT = "data/test.db.scheme.with_data.script";
	// private static final String DB_TEST_DB_XML = "data/test.db.xml";
	// private static final String DB_TEST_DB_DTD = "data/test.db.dtd";

	private MockMvc mockMvc;

	@Autowired
	private MainService mainService;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private DataSource dataSource;

	@Before
	public void setUp() {
		// read dataSet from dataSetURI
		ResourceDatabasePopulator tables = new ResourceDatabasePopulator();
		tables.addScript(new ClassPathResource(DB_TEST_DB_SCHEME_SCRIPT));

		DatabasePopulatorUtils.execute(tables, dataSource);

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	/*
	 * @Test public void aaa() throws Exception {
	 * mockMvc.perform(get("/computer")).andExpect(status().isOk())
	 * .andExpect(view().name("computer"));
	 * 
	 * // Возвращается ВСЕГДА errorPage при ошибке
	 * mockMvc.perform(get("/NoPageSASADS", 1L)).andExpect(status().isOk())
	 * .andExpect(forwardedUrl("default"));
	 * 
	 * // Есть Mock-объект(mainService в (frontend)/test-root-context.xml)
	 * verify(mainService, atLeast(1)).getComputerDao();
	 * 
	 * 
	 * // mockMvc.perform(get("/todo1/{id}",
	 * //1L)).andExpect(status().isNotFound())
	 * //.andExpect(view().name("error/404"))
	 * //.andExpect(forwardedUrl("/WEB-INF/jsp/error/404.jsp"));
	 * //verifyZeroInteractions(mainService);
	 * 
	 * }
	 */

	@Test
	public void listHdd() throws Exception {
		mockMvc.perform(get("/hdd")).andExpect(status().isOk())
				.andExpect(view().name("hdd"));
	}

	@Test
	public void listMonitor() throws Exception {
		mockMvc.perform(get("/monitor")).andExpect(status().isOk())
				.andExpect(view().name("monitor"));
	}

	@Test
	public void listMother() throws Exception {
		mockMvc.perform(get("/mother")).andExpect(status().isOk())
				.andExpect(view().name("mother"));
	}

	@Test
	public void listOs() throws Exception {
		mockMvc.perform(get("/os")).andExpect(status().isOk())
				.andExpect(view().name("os"));
	}

	@Test
	public void listPrinter() throws Exception {
		mockMvc.perform(get("/printer")).andExpect(status().isOk())
				.andExpect(view().name("printer"));
	}

	@Test
	public void listProcessor() throws Exception {
		mockMvc.perform(get("/processor")).andExpect(status().isOk())
				.andExpect(view().name("processor"));
	}

	@Test
	public void listRam() throws Exception {
		mockMvc.perform(get("/ram")).andExpect(status().isOk())
				.andExpect(view().name("ram"));
	}

	@Test
	public void listTypeHdd() throws Exception {
		mockMvc.perform(get("/type_hdd")).andExpect(status().isOk())
				.andExpect(view().name("type_hdd"));
	}

	@Test
	public void listTypeMother() throws Exception {
		mockMvc.perform(get("/type_mother")).andExpect(status().isOk())
				.andExpect(view().name("type_mother"));
	}

	@Test
	public void listTypeProc() throws Exception {
		mockMvc.perform(get("/type_proc")).andExpect(status().isOk())
				.andExpect(view().name("type_proc"));
	}

	@Test
	public void listTypeRam() throws Exception {
		mockMvc.perform(get("/type_ram")).andExpect(status().isOk())
				.andExpect(view().name("type_ram"));
	}

	@Test
	public void listUps() throws Exception {
		mockMvc.perform(get("/ups")).andExpect(status().isOk())
				.andExpect(view().name("ups"));
	}

	@Test
	public void listUser() throws Exception {
		mockMvc.perform(get("/user")).andExpect(status().isOk())
				.andExpect(view().name("user"));
	}

	@Test
	public void listComputer() throws Exception {
		mockMvc.perform(get("/computer")).andExpect(status().isOk())
				.andExpect(view().name("computer"));
	}

	/*
	 * @Test
	 * 
	 * @DatabaseSetup(DB_TABLES_DATA_FULL_FILE_XML) public void testDatabase() {
	 * 
	 * }
	 */

}
