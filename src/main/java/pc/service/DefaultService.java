package pc.service;

import java.util.List;


/**
 * <T> - POJO object
 * <K> - key*/
public interface DefaultService<T, K> {

	default int create(T o) {
		throw new RuntimeException("NO "+ this.getClass().getName() +" create() realization");
	}

	/** Read by K */
	default T read(K k){
		throw new RuntimeException("NO "+ this.getClass().getName() +" read() realization");
	}

	default void update(T o){
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
