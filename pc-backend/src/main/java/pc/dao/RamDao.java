package pc.dao;

import java.util.List;

import pc.model.Ram;

public  abstract class RamDao extends DefaultDao<Ram, Integer>{
	public List<Ram> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
