package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.repository.AuthorDao;
import pl.coderslab.app.repository.BookDao;
import pl.coderslab.app.repository.PublisherDao;

import java.util.HashSet;
import java.util.Set;

@Controller
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao BookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = BookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String save() {
        Book book = new Book();
        book.setTitle("Thinking in Java2");
        book.setRating(9);
        book.setDescription("Opis książki2");

        book.addAuthor(authorDao.findByIdWithBooks(1));
        book.addAuthor(authorDao.findByIdWithBooks(2));

//        Publisher publisher = new Publisher();
//        publisher.setName("Some publisher2");
//        publisherDao.savePublisher(publisher);

        book.setPublisher(publisherDao.findById(1));
        bookDao.saveBook(book);
//        book.setAuthor("Bruce Eckel");
        return "Id dodanej książki to:" + book.getId();
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }
}
