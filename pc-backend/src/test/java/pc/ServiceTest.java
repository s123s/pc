package pc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import pc.service.MainService;

@ContextConfiguration(locations = { "classpath:spring/test-root-context.xml" })
public class ServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private MainService mainService;

	@Test
	public void creationMAinServiceTest() {
		Assert.assertNotNull(mainService);
	}
}
