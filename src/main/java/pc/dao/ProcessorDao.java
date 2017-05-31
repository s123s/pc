package pc.dao;

import java.util.List;

import pc.model.Processor;

public interface ProcessorDao extends DefaultDao<Processor, Integer>{
	default List<Processor> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
