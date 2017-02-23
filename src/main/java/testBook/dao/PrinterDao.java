package testBook.dao;

import testBook.model.Printer;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public interface PrinterDao {

    public void addPrinter(Printer printer);
    public void updatePrinter(Printer printer);
    public void removePrinter(Long id);
    public Printer getPrinterById(Long id);
    public List<Printer> listPrinter();
}
