package pc.dao;

import java.util.List;

import pc.model.Hdd;

public interface HddDao extends DefaultDao<Hdd, Integer>{
	default List<Hdd> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
