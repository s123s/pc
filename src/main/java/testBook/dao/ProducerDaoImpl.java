package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Producer;

import java.util.List;

/**
 * Created by yasha on 20.04.2017.
 */
public class ProducerDaoImpl implements ProducerDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProducer(Producer producer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(producer);
    }

    @Override
    public void updateProducer(Producer producer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(producer);
    }

    @Override
    public void removeProducer(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Producer producer = (Producer) session.load(Producer.class, new Long(id));
        if(producer != null)
            session.delete(producer);
    }

    @Override
    public Producer getProducerById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Producer producer = (Producer) session.get(Producer.class, new Long(id));
        return producer;
    }

    @Override
    public List<Producer> listProducer() {
        Session session = sessionFactory.getCurrentSession();
        List producerList = session.createQuery("from Producer").list();
        return producerList;
    }
}
