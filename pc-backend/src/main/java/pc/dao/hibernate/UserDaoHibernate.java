package pc.dao.hibernate;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.UserDao;
import pc.model.User;
import pc.service.OperationStatus;

//@MappedSuperclass
public class UserDaoHibernate extends UserDao { 
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> readAll() {

		Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("from User order by idUser").list();
	}
	@Override
	@Transactional
	public OperationStatus update(User o) {
		Session session = this.getSessionFactory().getCurrentSession();
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
	public OperationStatus create(User o) {
		Session session = this.getSessionFactory().getCurrentSession();
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
		Session session = this.getSessionFactory().getCurrentSession();
		
		User o = new User();
		o.setIdUser(k);
	
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
