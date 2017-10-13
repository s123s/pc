package pc.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.UpsDao;
import pc.model.Ups;
import pc.service.OperationStatus;


public class UpsDaoHibernate extends UpsDao { 

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Ups> readAll() {

		Session session = getSessionFactory().getCurrentSession();
		return session.createQuery("from Ups order by idUps").list();
	}
	@Override
	@Transactional
	public OperationStatus update(Ups o) {
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
	public OperationStatus create(Ups o) {
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
		
		Ups o = new Ups();
		o.setIdUps(k);
	
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
