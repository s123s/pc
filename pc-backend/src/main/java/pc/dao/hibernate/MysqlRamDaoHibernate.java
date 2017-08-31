package pc.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.RamDao;
import pc.model.Computer;
import pc.model.Ram;
import pc.model.TypeRam;
import pc.service.OperationStatus;


public class MysqlRamDaoHibernate implements RamDao { 

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Ram> readAll() {

		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Ram order by idRam").list();
	}
	
/*	@Override
	@Transactional
	public List<Ram> readAllFreeRows() {
		List<Ram> rows = readAll();

		for (Iterator<Ram> iter = rows.iterator(); iter.hasNext(); ) {
			Ram ram = iter.next();
		    if (ram.get.getRams().size() != 0)  {
		        iter.remove();
		    }
		}
		return rows;
	}*/

	@Override
	@Transactional
	public OperationStatus update(Ram o) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			System.out.println(o.getClass()+ " updating");
			if (o.getComputer().getIdComputer() == null) o.setComputer(null);
			session.update(o);
			return new OperationStatus(true);
		}
		catch (HibernateException ex) {
			return new OperationStatus(false);
		}
	}
	
	
	@Override
	@Transactional
	public OperationStatus create(Ram o) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			System.out.println(o.getClass()+ " updating");
			//session.persist(o);
			if (o.getComputer().getIdComputer() == null) o.setComputer(null);
			//o.setTypeRam(session.load(TypeRam.class, o.getTypeRam().getIdTypeHdd()));
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
		
		Ram o = new Ram();
		o.setIdRam(k);
	
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
