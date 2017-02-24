package testBook.dao;

import testBook.model.Tram;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public interface TramDao {
    public void addTram(Tram tram);
    public void updateTram(Tram tram);
    public void removeTram(Long id);
    public Tram getTramById(Long id);
    public List<Tram> listTram();
}
