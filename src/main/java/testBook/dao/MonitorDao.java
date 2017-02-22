package testBook.dao;

import testBook.model.Monitor;

import java.util.List;

/**
 * Created by yasha on 22.02.2017.
 */
public interface MonitorDao {
    public void addMonitor(Monitor monitor);
    public void updateMonitor(Monitor monitor);
    public void removeMonitor(Long id);
    public Monitor getMonitorById(Long id);
    public List<Monitor> listMonitor();
}
