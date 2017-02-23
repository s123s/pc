package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Monitor;
import testBook.model.Printer;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public class PrinterDaoImpl implements PrinterDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addPrinter(Printer printer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(printer);
    }

    @Override
    public void updatePrinter(Printer printer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(printer);
    }

    @Override
    public void removePrinter(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Printer printer = (Printer) session.load(Printer.class, new Long(id));
        if(printer != null)
            session.delete(printer);
    }

    @Override
    public Printer getPrinterById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Printer printer  = (Printer) session.get(Printer.class, new Long(id));
        return printer;
    }

    @Override
    public List<Printer> listPrinter() {
        Session session = sessionFactory.getCurrentSession();
        List printerList = session.createQuery("from Printer").list();
        return printerList;
    }
}
