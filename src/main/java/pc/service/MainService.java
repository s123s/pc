package pc.service;

import org.springframework.stereotype.Service;

import pc.dao.TypeHddDao;
import pc.dao.TypeMotherDao;
import pc.dao.TypeProcDao;
import pc.dao.TypeRamDao;
import pc.dao.TypeRamSpecDao;
import pc.dao.WpDao;
import pc.dao.ProducerDao;

@Service
public class MainService implements DefaultService {


	private TypeRamDao typeRamDao;
	private TypeRamSpecDao typeRamSpecDao;
	private TypeHddDao typeHddDao;
	private WpDao wpDao;
	private ProducerDao producerDao;
	private TypeProcDao typeProcDao;
	private TypeMotherDao typeMotherDao;
	
	public TypeHddDao getTypeHddDao() {
		return typeHddDao;
	}
	public void setTypeHddDao(TypeHddDao typeHddDao) {
		this.typeHddDao = typeHddDao;
	}
	public WpDao getWpDao() {
		return wpDao;
	}
	public void setWpDao(WpDao wpDao) {
		this.wpDao = wpDao;
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

	
}
