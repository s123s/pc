package testBook.service;

import testBook.model.Book;

import java.util.List;

/**
 * Created by yasha on 04.12.2016.
 */
public interface BookService {
    public void addBook(Book book);
    public void updateBook(Book book);
    public void removeBook(Long id);
    public Book getBookById(long id);
    public List<Book> listBooks();
}
