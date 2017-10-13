package pc.dao;

import java.util.List;

import pc.model.Hdd;

public  abstract class HddDao extends DefaultDao<Hdd, Integer>{
	public List<Hdd> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
