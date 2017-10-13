package pc.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.HddDao;
import pc.model.Hdd;
import pc.service.OperationStatus;

public class HddDaoHibernate extends HddDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Hdd> readAll() {

		Session session = getSessionFactory().getCurrentSession();
		return session
				.createQuery(
						"from Hdd tab"
								+ " left outer join fetch tab.typeHdd"
								+ " left outer join fetch tab.computer"
								// OneToOne
								+ " left outer join fetch tab.computer.mother"
								+ " left outer join fetch tab.computer.processor"
								+ " left outer join fetch tab.computer.processor.typeProc"
								+ " left outer join fetch tab.computer.processor.typeProc.producer"
								+ " order by tab.idHdd").list();
	}

	/*
	 * @Override
	 * 
	 * @Transactional public List<Hdd> readAllFreeRows() { List<Hdd> rows =
	 * readAll();
	 * 
	 * for (Iterator<Hdd> iter = rows.iterator(); iter.hasNext(); ) { Hdd hdd =
	 * iter.next(); if (hdd.get.getHdds().size() != 0) { iter.remove(); } }
	 * return rows; }
	 */

	@Override
	@Transactional
	public OperationStatus update(Hdd o) {
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
	public OperationStatus create(Hdd o) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			System.out.println(o.getClass() + " updating");
			// session.persist(o);
			if (o.getComputer().getIdComputer() == null)
				o.setComputer(null);
			// o.setTypeHdd(session.load(TypeHdd.class,
			// o.getTypeHdd().getIdTypeHdd()));
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

		Hdd o = new Hdd();
		o.setIdHdd(k);

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
