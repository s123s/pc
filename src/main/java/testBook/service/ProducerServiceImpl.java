package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.ProducerDaoImpl;
import testBook.model.Producer;

import java.util.List;

/**
 * Created by yasha on 20.04.2017.
 */
public class ProducerServiceImpl implements ProducerService {

    private ProducerDaoImpl producerDao;


    public void setProducerDao(ProducerDaoImpl producerDao) {
        this.producerDao = producerDao;
    }

    public ProducerDaoImpl getProducerDao() {
        return producerDao;
    }



    @Override
    @Transactional
    public void addProducer(Producer producer) {
        this.producerDao.addProducer(producer);
    }

    @Override
    @Transactional
    public void updateProducer(Producer producer) {
        this.producerDao.updateProducer(producer);
    }

    @Override
    @Transactional
    public void removeProducer(Long id) {
        this.producerDao.removeProducer(id);
    }

    @Override
    @Transactional
    public Producer getProducerById(Long id) {
        return this.producerDao.getProducerById(id);
    }

    @Override
    @Transactional
    public List<Producer> listProducer() {
        return this.producerDao.listProducer();
    }
}
