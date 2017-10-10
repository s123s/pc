package pc.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.MonitorDao;
import pc.model.Monitor;
import pc.service.OperationStatus;


public class MysqlMonitorDaoHibernate implements MonitorDao { 

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Monitor> readAll() {

		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Monitor tab left outer join fetch tab.producer  order by tab.idMonitor").list();
	}
	@Override
	@Transactional
	public OperationStatus update(Monitor o) {
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
	public OperationStatus create(Monitor o) {
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
		
		Monitor o = new Monitor();
		o.setIdMonitor(k);
	
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
