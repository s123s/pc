package pc.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.ProcessorDao;
import pc.model.Processor;
import pc.service.OperationStatus;

public class ProcessorDaoHibernate extends ProcessorDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Processor> readAll() {

		Session session = getSessionFactory().getCurrentSession();
		return session.createQuery("from Processor order by idProcessor")
				.list();
	}

	@Override
	@Transactional
	public List<Processor> readAllFreeRows() {
		List<Processor> rows = readAll();

		for (Iterator<Processor> iter = rows.iterator(); iter.hasNext();) {
			Processor processorLocal = iter.next();
			if (processorLocal.hasComputer()
					&& processorLocal.getComputer().getIdComputer() != null) {
				iter.remove();
			}
		}
		return rows;
	}

	/*
	 * @Override
	 * 
	 * @Transactional public List<Processor> readAllFreeRows() { List<Processor>
	 * rows = readAll();
	 * 
	 * for (Iterator<Processor> iter = rows.iterator(); iter.hasNext(); ) {
	 * Processor processor = iter.next(); if
	 * (processor.get.getProcessors().size() != 0) { iter.remove(); } } return
	 * rows; }
	 */

	@Override
	@Transactional
	public OperationStatus update(Processor o) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			System.out.println(o.getClass() + " updating");
			if (o.getComputer().getIdComputer() == null)
				o.setComputer(null);
			session.update(o);
			return new OperationStatus(true);
		} catch (HibernateException ex) {
			return new OperationStatus(false);
		}
	}

	@Override
	@Transactional
	public OperationStatus create(Processor o) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			System.out.println(o.getClass() + " updating");
			// session.persist(o);
			if (o.getComputer().getIdComputer() == null)
				o.setComputer(null);
			// o.setTypeProcessor(session.load(TypeProcessor.class,
			// o.getTypeProcessor().getIdTypeHdd()));
			session.save(o);
			return new OperationStatus(true, o); // return o. ID filled
		} catch (HibernateException ex) {
			return new OperationStatus(false);
		}
	}

	@Override
	@Transactional
	public void delete(Integer k) {
		Session session = getSessionFactory().getCurrentSession();

		Processor o = new Processor();
		o.setIdProcessor(k);

		session.delete(o);
	}
	/*
	 * @Override
	 * 
	 * @Transactional public Book read(Integer k) { Session session =
	 * getSessionFactory().getCurrentSession(); return session.get(Book.class,
	 * k); }
	 * 
	 * 
	 * 
	 * @Override
	 * 
	 * @Transactional public int markDeleted(Integer k) { Session session =
	 * getSessionFactory().getCurrentSession(); Query query =
	 * session.createQuery
	 * ("update Book set deleted = 1 where id = :id").setParameter("id", k);
	 * 
	 * return query.executeUpdate(); }
	 */

}
