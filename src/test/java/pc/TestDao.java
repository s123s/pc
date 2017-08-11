package pc;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import pc.dao.hibernate.MysqlTypeHddDaoHibernate;
import pc.model.TypeHdd;

//@RunWith(SpringJUnit4ClassRunner.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//           @ContextConfiguration(locations = {"classpath:WEB-INF/mvc-dispatcher-servlet.xml"})

public class TestDao {
	  private MysqlTypeHddDaoHibernate typeHdd;

	@Before
    public void setUp() {
		typeHdd = new MysqlTypeHddDaoHibernate();
	
    }
	
    @After
    public void tearDown() {
//        emptyList = null;
    }
	@Test
	public void test () {
		//List<TypeHdd> list = typeHdd.readAll();
		assertNotNull(typeHdd);
		
	}
}
