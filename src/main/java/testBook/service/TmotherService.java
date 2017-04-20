package testBook.service;

import testBook.model.Tmother;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public interface TmotherService {
    public void addTmother(Tmother tmother);
    public void updateTmother(Tmother tmother);
    public void removeTmother(Long id);
    public Tmother getTmotherById(Long id);
    public List<Tmother> listTmother();
    public List<Tmother> listMotherNotComp();
}
