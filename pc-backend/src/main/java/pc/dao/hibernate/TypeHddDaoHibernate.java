package pc.dao.hibernate;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

import pc.dao.TypeHddDao;
import pc.model.TypeHdd;
import pc.service.OperationStatus;

public class TypeHddDaoHibernate extends TypeHddDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TypeHdd> readAll() {

		Session session = getSessionFactory().getCurrentSession();
		return session
				.createQuery(
						"from TypeHdd typeHdd left outer join fetch typeHdd.producer left outer join fetch typeHdd.hdds  order by typeHdd.idTypeHdd")
				.list();
	}

	@Override
	@Transactional
	public OperationStatus update(TypeHdd o) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			System.out.println(o.getClass() + " updating");
			session.update(o);
			return new OperationStatus(true);
		} catch (HibernateException ex) {
			return new OperationStatus(false);
		}
	}

	@Override
	@Transactional
	public OperationStatus create(TypeHdd o) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			System.out.println(o.getClass() + " updating");
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

		TypeHdd o = new TypeHdd();
		o.setIdTypeHdd(k);

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
