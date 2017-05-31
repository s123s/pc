package pc.dao;

import java.util.List;

import pc.model.Ram;

public interface RamDao extends DefaultDao<Ram, Integer>{
	default List<Ram> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
