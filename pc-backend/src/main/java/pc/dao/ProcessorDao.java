package pc.dao;

import java.util.List;

import pc.model.Processor;

public  abstract class ProcessorDao extends DefaultDao<Processor, Integer>{
	public List<Processor> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
