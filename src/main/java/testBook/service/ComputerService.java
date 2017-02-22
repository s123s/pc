package testBook.service;

import testBook.model.Computer;

import java.util.List;

/**
 * Created by yasha on 21.02.2017.
 */
public interface ComputerService {

    public void addComputer(Computer computer);
    public void updateComputer(Computer computer);
    public void removeComputer(Long id);
    public Computer getComputerById(Long id);
    public List<Computer> listComputer();
}
