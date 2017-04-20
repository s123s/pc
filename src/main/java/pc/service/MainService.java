package pc.service;

import org.springframework.stereotype.Service;

import pc.dao.TypeHddDao;
import pc.dao.WpDao;
import pc.dao.ProducerDao;

@Service
public class MainService implements DefaultService {

	
	private TypeHddDao typeHddDao;
	private WpDao wpDao;
	private ProducerDao producerDao;
	
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
	
}
