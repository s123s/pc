package pc.service;

import org.springframework.stereotype.Service;

import pc.dao.TypeHddDao;
import pc.dao.WpDao;

@Service
public class MainService implements DefaultService {

	
	private TypeHddDao typeHddDao;
	private WpDao wpDao;
	
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
	

}
