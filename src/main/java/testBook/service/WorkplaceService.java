package testBook.service;

import testBook.model.Workplace;

import java.util.List;

/**
 * Created by yasha on 14.03.2017.
 */
public interface WorkplaceService {
    public void addWorkplace(Workplace workplace);
    public void updateWorkplace(Workplace workplace);
    public void removeWorkplace(Long id);
    public Workplace getWorkplaceById(Long id);
    public List<Workplace> listWorkplace();
}
