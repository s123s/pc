package pc.dao;

import java.util.List;

import pc.model.Computer;

public interface ComputerDao extends DefaultDao<Computer, Integer>{
	default List<Computer> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
