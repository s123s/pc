package pc.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.ComputerDao;
import pc.model.Computer;
import pc.model.Computer;
import pc.model.TypeProc;
import pc.service.OperationStatus;


public class MysqlComputerDaoHibernate implements ComputerDao { 

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Computer> readAll() {

		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Computer order by idComputer").list();
	}
	
/*	@Override
	@Transactional
	public List<Computer> readAllFreeRows() {
		List<Computer> rows = readAll();

		for (Iterator<Computer> iter = rows.iterator(); iter.hasNext(); ) {
			Computer processor = iter.next();
		    if (processor.get.getComputers().size() != 0)  {
		        iter.remove();
		    }
		}
		return rows;
	}*/

	@Override
	@Transactional
	public OperationStatus update(Computer o) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			System.out.println(o.getClass()+ " updating");
			//if (o.getComputer().getIdComputer() == null) o.setComputer(null);
			session.update(o);
			return new OperationStatus(true);
		}
		catch (HibernateException ex) {
			return new OperationStatus(false);
		}
	}
	
	
	@Override
	@Transactional
	public OperationStatus create(Computer o) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			System.out.println(o.getClass()+ " updating");
			//session.persist(o);
			//if (o.getComputer().getIdComputer() == null) o.setComputer(null);
			//o.setTypeComputer(session.load(TypeComputer.class, o.getTypeComputer().getIdTypeHdd()));
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
		
		Computer o = new Computer();
		o.setIdComputer(k);
	
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
