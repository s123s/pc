package pc.dao;

import java.util.List;

import pc.model.Hdd;
import pc.model.TypeMother;

public interface TypeMotherDao extends DefaultDao<TypeMother, Integer>{
	default public List<TypeMother> readAllFreeRows() {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAllFreeRows() realization");
	}
}
