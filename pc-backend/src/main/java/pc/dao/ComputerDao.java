package pc.dao;

import java.util.List;

import javax.persistence.MappedSuperclass;

import pc.model.Computer;

@MappedSuperclass
public  abstract class ComputerDao extends DefaultDao<Computer, Integer>{
	public List<Computer> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
