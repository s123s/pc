package pc.dao;

import java.util.List;

import pc.model.Computer;

public  abstract class ComputerDao extends DefaultDao<Computer, Integer>{
	public List<Computer> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
