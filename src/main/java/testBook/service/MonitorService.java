package testBook.service;

import testBook.model.Monitor;

import java.util.List;

/**
 * Created by yasha on 22.02.2017.
 */
public interface MonitorService {
    public void addMonitor(Monitor computer);
    public void updateMonitor(Monitor computer);
    public void removeMonitor(Long id);
    public Monitor getMonitorById(Long id);
    public List<Monitor> listMonitor();
}
