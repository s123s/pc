package pc.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import pc.dao.MotherDao;
import pc.model.Mother;
import pc.service.OperationStatus;

public class MotherDaoHibernate extends MotherDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Mother> readAll() {

		Session session = getSessionFactory().getCurrentSession();
		return session.createQuery("from Mother tab "
				+ "left outer join fetch tab.typeMother order by tab.idMother").list();
	}

	@Override
	@Transactional
	public List<Mother> readAllFreeRows() {
		List<Mother> rows = readAll();

		for (Iterator<Mother> iter = rows.iterator(); iter.hasNext();) {
			Mother motherLocal = iter.next();
			if (motherLocal.hasComputer()
					&& motherLocal.getComputer().getIdComputer() != null) {
				iter.remove();
			}
		}
		return rows;
	}

	@Override
	@Transactional
	public OperationStatus update(Mother o) {
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
	public OperationStatus create(Mother o) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			System.out.println(o.getClass() + " updating");
			// session.persist(o);
			if (o.getComputer().getIdComputer() == null)
				o.setComputer(null);
			// o.setTypeMother(session.load(TypeMother.class,
			// o.getTypeMother().getIdTypeHdd()));
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

		Mother o = new Mother();
		o.setIdMother(k);

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
