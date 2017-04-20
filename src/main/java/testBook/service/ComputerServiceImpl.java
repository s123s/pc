package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.ComputerDaoImpl;
import testBook.model.Computer;

import java.util.List;

/**
 * Created by yasha on 21.02.2017.
 */
public class ComputerServiceImpl implements ComputerService {

    private ComputerDaoImpl computerDao;


    public void setComputerDao(ComputerDaoImpl computerDao) {
        this.computerDao = computerDao;
    }

       public ComputerDaoImpl getComputerDao() {
        return computerDao;
    }

    @Override
    @Transactional
    public void addComputer(Computer computer) {
this.computerDao.addComputer(computer);
    }

    @Override
    @Transactional
    public void updateComputer(Computer computer) {
        this.computerDao.updateComputer(computer);

    }

    @Override
    @Transactional
    public void removeComputer(Long id) {
        this.computerDao.removeComputer(id);

    }

    @Override
    @Transactional
    public Computer getComputerById(Long id) {
        return this.computerDao.getComputerById(id);
    }

    @Override
    @Transactional
    public List<Computer> listComputer() {
        return this.computerDao.listComputer();
    }
}
