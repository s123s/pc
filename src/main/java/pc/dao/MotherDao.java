package pc.dao;

import java.util.List;

import pc.model.Mother;

public interface MotherDao extends DefaultDao<Mother, Integer>{
	default List<Mother> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
