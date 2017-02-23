package testBook.dao;

import testBook.model.Os;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public interface OsDao {

    public void addOs(Os os);
    public void updateOs(Os os);
    public void removeOs(Long id);
    public Os getOsById(Long id);
    public List<Os> listOs();
}
