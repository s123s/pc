package pc.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.RamDao;
import pc.model.Ram;
import pc.service.OperationStatus;


public class RamDaoHibernate extends RamDao { 

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Ram> readAll() {

		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
		
		Ram o = new Ram();
		o.setIdRam(k);
	
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
