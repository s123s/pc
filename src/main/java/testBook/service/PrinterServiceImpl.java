package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.PrinterDaoImpl;
import testBook.model.Printer;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public class PrinterServiceImpl implements PrinterService {

    private PrinterDaoImpl printerDao;


    public void setPrinterDao(PrinterDaoImpl printerDao) {
        this.printerDao = printerDao;
    }

    public PrinterDaoImpl getPrinterDao() {
        return printerDao;
    }


    @Override
    @Transactional
    public void addPrinter(Printer printer) {
        this.printerDao.addPrinter(printer);
    }

    @Override
    @Transactional
    public void updatePrinter(Printer printer) {
        this.printerDao.updatePrinter(printer);
    }

    @Override
    @Transactional
    public void removePrinter(Long id) {
        this.printerDao.removePrinter(id);
    }

    @Override
    @Transactional
    public Printer getPrinterById(Long id) {
        return this.printerDao.getPrinterById(id);
    }

    @Override
    @Transactional
    public List<Printer> listPrinter() {
        return this.printerDao.listPrinter();
    }
}
