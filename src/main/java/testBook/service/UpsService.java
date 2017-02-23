package testBook.service;

import testBook.model.Ups;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public interface UpsService {

    public void addUps(Ups ups);
    public void updateUps(Ups ups);
    public void removeUps(Long id);
    public Ups getUpsById(Long id);
    public List<Ups> listUps();
}
