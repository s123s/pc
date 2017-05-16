package pc.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.DefaultDao;
import pc.dao.TypeHddDao;
import pc.model.TypeHdd;
import pc.service.OperationStatus;


public class MysqlTypeHddDaoHibernate implements TypeHddDao { 
//TypeHddDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<TypeHdd> readAll() {

		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from TypeHdd order by idTypeHdd").list();
	}

	@Override
	@Transactional
	public List<TypeHdd> readAllFreeRows() {
		List<TypeHdd> rows = readAll();

		for (Iterator<TypeHdd> iter = rows.iterator(); iter.hasNext(); ) {
			TypeHdd typeHdd = iter.next();
		    if (typeHdd.getHdds().size() != 0)  {
		        iter.remove();
		    }
		}
		return rows;
	}

	
	@Override
	@Transactional
	public OperationStatus update(TypeHdd o) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			System.out.println(o.getClass()+ " updating");
			session.update(o);
			return new OperationStatus(true);
		}
		catch (HibernateException ex) {
			return new OperationStatus(false);
		}
	}
	
	@Override
	@Transactional
	public OperationStatus create(TypeHdd o) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			System.out.println(o.getClass()+ " updating");
			session.save(o);
			return new OperationStatus(true, o);	//return o. ID filled
		}
		catch (HibernateException ex) {
			return new OperationStatus(false);
		}
	}
	
	@Override
	@Transactional
	public void delete(Integer k) {
		Session session = this.sessionFactory.getCurrentSession();
		
		TypeHdd o = new TypeHdd();
		o.setIdTypeHdd(k);
	
		session.delete(o);
	}
	/*
	@Override
	@Transactional
	public Book read(Integer k) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Book.class, k);
	}



	@Override
	@Transactional
	public int markDeleted(Integer k) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Book set deleted = 1 where id = :id").setParameter("id", k);
		
		return query.executeUpdate();
	}*/

}
