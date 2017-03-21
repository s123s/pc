package pc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pc.model.TypeHdd;
import pc.dao.TypeHddDao;

@Service
public class TypeHddServiceImpl implements TypeHddService {

	private TypeHddDao typeHddDao;

	@Override
	public List<TypeHdd> readAll() {
		return typeHddDao.readAll();
	}

	public TypeHdd read(Integer o) {
		return typeHddDao.read(o);
	}


	public void update(TypeHdd o) {
		getWpDao().update(o);
	}

	public int markDeleted(Integer k) {
		return getWpDao().markDeleted(k);
	}

	public TypeHddDao getWpDao() {
		return typeHddDao;
	}

	public void setWpDao(TypeHddDao wpDao) {
		this.typeHddDao = wpDao;
	}

}
