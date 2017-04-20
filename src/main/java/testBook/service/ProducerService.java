package testBook.service;

import testBook.model.Producer;

import java.util.List;

/**
 * Created by yasha on 20.04.2017.
 */
public interface ProducerService {
    public void addProducer(Producer producer);
    public void updateProducer(Producer producer);
    public void removeProducer(Long id);
    public Producer getProducerById(Long id);
    public List<Producer> listProducer();
}
