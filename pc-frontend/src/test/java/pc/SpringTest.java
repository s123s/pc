package pc;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import pc.dao.ComputerDao;
import pc.dao.HddDao;
import pc.dao.MonitorDao;
import pc.dao.MotherDao;
import pc.dao.OsDao;
import pc.dao.PrinterDao;
import pc.dao.ProcessorDao;
import pc.dao.ProducerDao;
import pc.dao.RamDao;
import pc.dao.TypeComputerDao;
import pc.dao.TypeHddDao;
import pc.dao.TypeMotherDao;
import pc.dao.TypeProcDao;
import pc.dao.TypeRamDao;
import pc.dao.TypeRamSpecDao;
import pc.dao.UpsDao;
import pc.dao.UserDao;
import pc.dao.WorkplaceDao;
import pc.dao.WpDao;
import pc.model.Computer;
import pc.model.Hdd;
import pc.model.Monitor;
import pc.model.Mother;
import pc.model.Os;
import pc.model.Printer;
import pc.model.Processor;
import pc.model.Producer;
import pc.model.Ram;
import pc.model.TypeComputer;
import pc.model.TypeHdd;
import pc.model.TypeMother;
import pc.model.TypeProc;
import pc.model.TypeRam;
import pc.model.TypeRamSpec;
import pc.model.Ups;
import pc.model.User;
import pc.model.Workplace;
import pc.model.WpSummView;

@ContextConfiguration(locations = {"classpath:spring/test-root-context.xml" }) 
public class SpringTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private TypeRamDao typeRamDao;
	@Autowired
	private TypeRamSpecDao typeRamSpecDao;
	@Autowired
	private TypeHddDao typeHddDao;
	@Autowired
	private WpDao wpDao;
	@Autowired
	private ProducerDao producerDao;
	@Autowired
	private TypeProcDao typeProcDao;
	@Autowired
	private TypeMotherDao typeMotherDao;
	@Autowired
	private OsDao osDao;
	@Autowired
	private UpsDao upsDao;
	@Autowired
	private PrinterDao printerDao;
	@Autowired
	private MonitorDao monitorDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private HddDao hddDao;
	@Autowired
	private RamDao ramDao;
	@Autowired
	private ProcessorDao processorDao;
	@Autowired
	private MotherDao motherDao;
	@Autowired
	private ComputerDao computerDao;
	@Autowired
	private TypeComputerDao typeComputerDao;
	@Autowired
	private WorkplaceDao  workplaceDao;
	
	
	@Test
	public void typeRamDaoTest() {
		List<TypeRam> listResult = typeRamDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}
	
	@Test
	public void typeRamSpecDaoTest() {
		List<TypeRamSpec> listResult = typeRamSpecDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}
	
	@Test
	public void TypeHddDaoTest() {
//		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("/spring/test-root-context.xml");
//		TypeHddDao bean = (TypeHddDao)ac.getBean("typeHddDao");
		List<TypeHdd> listResult = typeHddDao.readAll();
		System.out.println(listResult.get(0).getProducer());
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}
	
	@Test
	public void wpDaoTest() {
		List<WpSummView> listResult = wpDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void producerDaoTest() {
		List<Producer> listResult = producerDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void typeProcDaoTest() {
		List<TypeProc> listResult = typeProcDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void typeMotherDaoTest() {
		List<TypeMother> listResult = typeMotherDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void osDaoTest() {
		List<Os> listResult = osDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void upsDaoTest() {
		List<Ups> listResult = upsDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}
	
	@Test
	public void printerDaoTest() {
		List<Printer> listResult = printerDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}
	
	@Test
	public void monitorDaoTest() {
		List<Monitor> listResult = monitorDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}
	
	@Test
	public void userDaoTest() {
		List<User> listResult = userDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}
	
	@Test
	public void hddDaoTest() {
		List<Hdd> listResult = hddDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void ramDaoTest() {
		List<Ram> listResult = ramDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void processorDaoTest() {
		List<Processor> listResult = processorDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}	

	@Test
	public void motherDaoTest() {
		List<Mother> listResult = motherDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void computerDaoTest() {
		List<Computer> listResult = computerDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void typeComputerDaoTest() {
		List<TypeComputer> listResult = typeComputerDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}

	@Test
	public void workplaceDaoTest() {
		List<Workplace> listResult = workplaceDao.readAll();
		System.out.println("size= " +listResult.size());
		Assert.assertFalse(listResult.isEmpty());
	}	
}
