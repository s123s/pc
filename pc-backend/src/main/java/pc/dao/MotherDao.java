package pc.dao;

import java.util.List;

import pc.model.Mother;

public abstract class MotherDao extends DefaultDao<Mother, Integer>{
	public List<Mother> readAllFreeRows () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
