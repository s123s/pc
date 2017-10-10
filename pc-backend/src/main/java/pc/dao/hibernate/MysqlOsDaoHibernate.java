package pc.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.OsDao;
import pc.model.Os;
import pc.service.OperationStatus;


public class MysqlOsDaoHibernate implements OsDao { 

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Os> readAll() {

		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Os order by idOs").list();
	}
	@Override
	@Transactional
	public OperationStatus update(Os o) {
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
	public OperationStatus create(Os o) {
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
		
		Os o = new Os();
		o.setIdOs(k);
	
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
