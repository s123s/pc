package pc.service;

import org.springframework.stereotype.Service;

import pc.dao.ComputerDao;
import pc.dao.HddDao;
import pc.dao.MonitorDao;
import pc.dao.MotherDao;
import pc.dao.PrinterDao;
import pc.dao.OsDao;
import pc.dao.ProcessorDao;
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
import pc.dao.ProducerDao;

@Service
public class MainService implements DefaultService {

	private TypeRamDao typeRamDao;
	private TypeRamSpecDao typeRamSpecDao;
	private TypeHddDao typeHddDao;
	private ProducerDao producerDao;
	private TypeProcDao typeProcDao;
	private TypeMotherDao typeMotherDao;
	private OsDao osDao;
	private UpsDao upsDao;
	private PrinterDao printerDao;
	private MonitorDao monitorDao;
	private UserDao userDao;
	private HddDao hddDao;
	private RamDao ramDao;
	private ProcessorDao processorDao;
	private MotherDao motherDao;
	private ComputerDao computerDao;
	private TypeComputerDao typeComputerDao;
	private WorkplaceDao workplaceDao;

	public TypeHddDao getTypeHddDao() {
		return typeHddDao;
	}

	public void setTypeHddDao(TypeHddDao typeHddDao) {
		this.typeHddDao = typeHddDao;
	}


	public ProducerDao getProducerDao() {
		return producerDao;
	}

	public void setProducerDao(ProducerDao producerDao) {
		this.producerDao = producerDao;
	}

	public TypeRamDao getTypeRamDao() {
		return typeRamDao;
	}

	public void setTypeRamDao(TypeRamDao typeRamDao) {
		this.typeRamDao = typeRamDao;
	}

	public TypeRamSpecDao getTypeRamSpecDao() {
		return typeRamSpecDao;
	}

	public void setTypeRamSpecDao(TypeRamSpecDao typeRamSpecDao) {
		this.typeRamSpecDao = typeRamSpecDao;
	}

	public TypeProcDao getTypeProcDao() {
		return typeProcDao;
	}

	public void setTypeProcDao(TypeProcDao typeProcDao) {
		this.typeProcDao = typeProcDao;
	}

	public TypeMotherDao getTypeMotherDao() {
		return typeMotherDao;
	}

	public void setTypeMotherDao(TypeMotherDao typeMotherDao) {
		this.typeMotherDao = typeMotherDao;
	}

	public OsDao getOsDao() {
		return osDao;
	}

	public void setOsDao(OsDao osDao) {
		this.osDao = osDao;
	}

	public UpsDao getUpsDao() {
		return upsDao;
	}

	public void setUpsDao(UpsDao upsDao) {
		this.upsDao = upsDao;
	}

	public PrinterDao getPrinterDao() {
		return printerDao;
	}

	public void setPrinterDao(PrinterDao printerDao) {
		this.printerDao = printerDao;
	}

	public MonitorDao getMonitorDao() {
		return monitorDao;
	}

	public void setMonitorDao(MonitorDao monitorDao) {
		this.monitorDao = monitorDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public HddDao getHddDao() {
		return hddDao;
	}

	public void setHddDao(HddDao hddDao) {
		this.hddDao = hddDao;
	}

	public RamDao getRamDao() {
		return ramDao;
	}

	public void setRamDao(RamDao ramDao) {
		this.ramDao = ramDao;
	}

	public ProcessorDao getProcessorDao() {
		return processorDao;
	}

	public void setProcessorDao(ProcessorDao processorDao) {
		this.processorDao = processorDao;
	}

	public MotherDao getMotherDao() {
		return motherDao;
	}

	public void setMotherDao(MotherDao motherDao) {
		this.motherDao = motherDao;
	}

	public ComputerDao getComputerDao() {
		return computerDao;
	}

	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}

	public TypeComputerDao getTypeComputerDao() {
		return typeComputerDao;
	}

	public void setTypeComputerDao(TypeComputerDao typeComputerDao) {
		this.typeComputerDao = typeComputerDao;
	}

	public WorkplaceDao getWorkplaceDao() {
		return workplaceDao;
	}

	public void setWorkplaceDao(WorkplaceDao workplaceDao) {
		this.workplaceDao = workplaceDao;
	}

}
