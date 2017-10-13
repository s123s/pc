package pc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pc.service.OperationStatus;


/**<T> - POJO object
 * <K> - key*/
public abstract class DefaultDao<T, K> {

	public SessionFactory sessionFactory;
	
	public OperationStatus create(T o) {
		throw new RuntimeException("NO "+ this.getClass().getName() +" create() realization");
	}

	/** Read by K */
	public T read(K k){
		throw new RuntimeException("NO "+ this.getClass().getName() +" read() realization");
	}

	public OperationStatus update(T o){
		throw new RuntimeException("NO "+ this.getClass().getName() +" update() realization");
	}

	public void delete(K k){
		throw new RuntimeException("NO "+ this.getClass().getName() +" delete() realization");
	}

	public int markDeleted(K k){
		throw new RuntimeException("NO "+ this.getClass().getName() +" markDeleted() realization");
	}
	
	public List<T> readAll () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAll() realization");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
