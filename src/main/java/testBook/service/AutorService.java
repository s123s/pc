package testBook.service;

import testBook.model.Autor;

import java.util.List;

/**
 * Created by yasha on 11.12.2016.
 */
public interface AutorService {
    public void addAutor(Autor autor);
    public void updateAutor(Autor autor);
    public void removeAutor(Long id);
    public Autor getAutorById(Long id);
    public List<Autor> listAutor();
}
