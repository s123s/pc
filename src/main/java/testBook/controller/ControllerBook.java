package testBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import testBook.model.Autor;
import testBook.model.Book;
import testBook.model.Wp;
import testBook.service.AutorService;
import testBook.service.BookService;
import testBook.service.WpService;

/**
 * Created by yasha on 04.12.2016.
 */
@Controller
public class ControllerBook {
    private BookService bookService;
    private AutorService autorService;
    private WpService wpService;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setServiceBook(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    @Qualifier(value = "autorService")
    public void setAutorService(AutorService autorService){
        this.autorService = autorService;
    }

    @Autowired
    @Qualifier(value = "wpService")
    public void setWpService(WpService wpService){
        this.wpService = wpService;
    }


    @RequestMapping(value = "/wp")
    public String listWp(Model model){
      model.addAttribute("wp", new Wp());
        model.addAttribute("listWp", this.wpService.listWp());
        return "wp";
    }
    @RequestMapping(value = "/books")
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "books";
    }

    @RequestMapping(value = "autors")
    public String listAutors(Model model){
        model.addAttribute("autor", new Autor());
        model.addAttribute("listAutors", this.autorService.listAutor());
        return "autors";
    }
    @RequestMapping(value="add")
    public String addBook(@ModelAttribute("book") Book book, Model model) {
        this.bookService.addBook(book);
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "books";
    }
    @RequestMapping(value="addAutor")
    public String addAutor(@ModelAttribute("autor") Autor autor, Model model) {
        this.autorService.addAutor(autor);
        model.addAttribute("listAutors", this.autorService.listAutor());
        return "autors";
    }
    @RequestMapping(value="editAutor/{id}")
    public String editAutor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("autor", this.autorService.getAutorById(id));

        return "/editAutors";
    }
    @RequestMapping(value="edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        System.out.println(this.bookService.getBookById(id));
        return "/editBook";
    }
    @RequestMapping(value="/update")
    public String updateBook(@ModelAttribute("book") Book book){
        this.bookService.updateBook(book);

        return "redirect:/books";
    }
    @RequestMapping(value="/updateAutor")
    public String updateAutor(@ModelAttribute("autor") Autor autor) {
        if (autor.getId() == 0) {
            this.autorService.addAutor(autor);
        } else {
            this.autorService.updateAutor(autor);
        }
            return "redirect:/autors";
        }

    @RequestMapping("remove/{id}")
    public String removeBook(@PathVariable("id") Long id){
        this.bookService.removeBook(id);
        return "redirect:/books";
    }
    @RequestMapping("removeAutor/{id}")
    public String removeAutor(@PathVariable("id") Long id){
        this.autorService.removeAutor(id);
        return "redirect:/autors";
    }

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/login-failure")
    public String loginFailure() {
        return "accesDenied";
    }
   /* @RequestMapping(value="autor/{autor_id}", method = RequestMethod.GET)
public String getAutorById(@PathVariable("autor_id") Long id, Model model){
        model.addAttribute("autork",this.autorService.getAutorById(id).getName());
        return "redirect:/books";*/

}
