package testBook.dao;

import testBook.model.Book;

import java.util.List;

/**
 * Created by yasha on 04.12.2016.
 */
public interface BookDao {
    public void addBook(Book book);
    public void updateBook(Book book);
    public void removeBook(Long id);
    public Book getBookById(Long id);
    public List<Book> listBook();
}
