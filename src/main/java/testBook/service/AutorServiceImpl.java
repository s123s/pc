package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.AutorDaoImpl;
import testBook.model.Autor;

import java.util.List;

/**
 * Created by yasha on 11.12.2016.
 */
public class AutorServiceImpl implements AutorService {

    private AutorDaoImpl autorDao;

    public void setAutorDao(AutorDaoImpl autorDao){
        this.autorDao = autorDao;
    }
    public AutorDaoImpl getAutorDao(){
        return autorDao;
    }

    @Override
    @Transactional
    public void addAutor(Autor autor) {
        this.autorDao.addAutor(autor);
            }

    @Override
    @Transactional
    public void updateAutor(Autor autor) {
        this.autorDao.updateAutor(autor);
    }

    @Override
    @Transactional
    public void removeAutor(Long id) {
        this.autorDao.removeAutor(id);
    }

    @Override
    @Transactional
    public Autor getAutorById(Long id) {
        return this.autorDao.getAutorById(id);

    }

    @Override
    @Transactional

    public List<Autor> listAutor() {
        return this.autorDao.listAutor();
    }
}
