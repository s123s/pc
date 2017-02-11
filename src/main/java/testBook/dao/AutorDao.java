package testBook.dao;

import testBook.model.Autor;

import java.util.List;

/**
 * Created by yasha on 10.12.2016.
 */
public interface AutorDao {
    public void addAutor(Autor autor);
    public void updateAutor(Autor autor);
    public void removeAutor(Long id);
    public Autor getAutorById(Long id);
    public List<Autor> listAutor();
}
