package pc.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.ComputerDao;
import pc.model.Computer;
import pc.model.Mother;
import pc.model.Processor;
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
		return session.createQuery("from Computer tab left outer join fetch tab.workplace left outer join fetch tab.rams "
				//OneToOne
				+ " left outer join fetch tab.mother left outer join fetch tab.processor order by tab.idComputer").list();
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
			
			Mother mother = o.getMother();
			mother = (Mother)session.load(Mother.class, mother.getIdMother());
			if (mother.getIdMother() != null) {
				mother.setComputer((Computer)o.clone());session.save(mother);
			}

			Processor processor = o.getProcessor();
			processor = (Processor)session.load(Processor.class, processor.getIdProcessor());
			if (processor.getIdProcessor() != null) {
				processor.setComputer((Computer)o.clone());session.save(processor);
			}
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
