package pc.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.WorkplaceDao;
import pc.model.Workplace;
import pc.service.OperationStatus;


public class WorkplaceDaoHibernate extends WorkplaceDao { 
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Workplace> readAll() {

		Session session = getSessionFactory().getCurrentSession();
		return session.createQuery("from Workplace order by idWorkplace").list();
	}
	@Override
	@Transactional
	public OperationStatus update(Workplace o) {
		Session session = getSessionFactory().getCurrentSession();
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
	public OperationStatus create(Workplace o) {
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
		
		Workplace o = new Workplace();
		o.setIdWorkplace(k);
	
		session.delete(o);
	}
	/*
	@Override
	@Transactional
	public Book read(Integer k) {
		Session session = getSessionFactory().getCurrentSession();
		return session.get(Book.class, k);
	}



	@Override
	@Transactional
	public int markDeleted(Integer k) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("update Book set deleted = 1 where id = :id").setParameter("id", k);
		
		return query.executeUpdate();
	}*/

}
