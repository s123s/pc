package testBook.service;

import testBook.model.Tproc;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public interface TprocService {
    public void addTproc(Tproc tproc);
    public void updateTproc(Tproc tproc);
    public void removeTproc(Long id);
    public Tproc getTprocById(Long id);
    public List<Tproc> listTproc();
}
