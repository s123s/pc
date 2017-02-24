package testBook.service;

import testBook.model.Tram;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public interface TramService {
    public void addTram(Tram tram);
    public void updateTram(Tram tram);
    public void removeTram(Long id);
    public Tram getTramById(Long id);
    public List<Tram> listTram();
}
