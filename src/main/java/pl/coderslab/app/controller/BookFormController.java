package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.repository.BookDao;
import pl.coderslab.app.repository.PublisherDao;

import java.util.List;

@Controller
@RequestMapping("/bookBind")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.getAll();
    }


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/form")
//    @ResponseBody
    public String processForm(Book book) {
        bookDao.saveBook(book);
        return "redirect:list";
//        return "Id dodanej książki: " + book.getId();
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Book byId = bookDao.findById(id);
        model.addAttribute("book", byId);
        return "book/edit";
    }

}
