package pc.dao;

import java.util.List;

import pc.service.OperationStatus;


/**<T> - POJO object
 * <K> - key*/
public interface DefaultDao<T, K> {

	default int create(T o) {
		throw new RuntimeException("NO "+ this.getClass().getName() +" create() realization");
	}

	/** Read by K */
	default T read(K k){
		throw new RuntimeException("NO "+ this.getClass().getName() +" read() realization");
	}

	default OperationStatus update(T o){
		throw new RuntimeException("NO "+ this.getClass().getName() +" update() realization");
	}

	default void delete(K k){
		throw new RuntimeException("NO "+ this.getClass().getName() +" delete() realization");
	}

	default int markDeleted(K k){
		throw new RuntimeException("NO "+ this.getClass().getName() +" markDeleted() realization");
	}
	
	default List<T> readAll () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAll() realization");
	}
}
