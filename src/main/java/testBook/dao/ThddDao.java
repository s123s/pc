package testBook.dao;

import testBook.model.Thdd;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public interface ThddDao {
    public void addThdd(Thdd thdd);
    public void updateThdd(Thdd thdd);
    public void removeThdd(Long id);
    public Thdd getThddById(Long id);
    public List<Thdd> listThdd();
}
