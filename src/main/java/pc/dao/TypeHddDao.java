package pc.dao;

import java.util.List;

import pc.model.TypeHdd;

public interface TypeHddDao extends DefaultDao<TypeHdd, Integer>{
	default List<TypeHdd> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
