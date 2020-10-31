package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.repository.BookDao;

@Controller
public class BookController {

    private final BookDao BookDao;

    public BookController(BookDao BookDao) {
        this.BookDao = BookDao;
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String save() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
//        book.setAuthor("Bruce Eckel");
        BookDao.saveBook(book);
        return "Id dodanej książki to:" + book.getId();
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = BookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = BookDao.findById(id);
        book.setTitle(title);
        BookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = BookDao.findById(id);
        BookDao.delete(book);
        return "deleted";
    }
}
