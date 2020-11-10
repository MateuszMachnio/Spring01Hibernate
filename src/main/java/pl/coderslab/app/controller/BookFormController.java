package pl.coderslab.app.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Category;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.jpaRepository.BookRepository;
import pl.coderslab.app.jpaRepository.CategoryRepository;
import pl.coderslab.app.repository.AuthorDao;
import pl.coderslab.app.repository.BookDao;
import pl.coderslab.app.repository.PublisherDao;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book-bind")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.getAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.getAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/form")
//    @ResponseBody
    public String processForm(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/form";
        } else {
            bookRepository.save(book);
//            if (book.getId() != null) {
//                bookDao.update(book);
//            } else {
//                bookDao.saveBook(book);
//            }
        }
        return "redirect:list";
//        return "Id dodanej książki: " + book.getId();
    }

    @GetMapping("/list")
    public String list(Model model) {
//        List<Book> books = bookDao.findAll();
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/edit/{id}")
    @Transactional
    public String editForm(@PathVariable long id, Model model) {
        Optional<Book> book = bookRepository.findById(id);
//        Book book = bookDao.findByIdWithAuthors(id);
        Book found = book.orElseThrow(() -> new EntityNotFoundException("Book not found"));
        Hibernate.initialize(found.getAuthors());
        model.addAttribute("book", found);
        return "book/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/edit";
        }
        bookDao.update(book);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable long id, Model model) {
        Book byId = bookDao.findById(id);
        model.addAttribute("book", byId);
        return "book/deleting-confirmation";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book-bind/list";
    }

    @GetMapping("/list-by-title/{title}")
    public String list(Model model, @PathVariable String title) {
//        List<Book> books = bookDao.findAll();
//        List<Book> books = bookRepository.findByTitle(title);
        List<Book> books = bookRepository.findBooksByTitle(title);
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/list-by-category-id/{category_id}")
    public String list(Model model, @PathVariable long category_id) {
//        List<Book> books = bookDao.findAll();
        Optional<Category> category = categoryRepository.findById(category_id);
        List<Book> books = bookRepository.findBooksByCategory(category.orElseThrow(() -> new EntityNotFoundException("Category not found")));
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/list-by-category/{category_id}")
    public String listBooks(Model model, @PathVariable long category_id) {
//        List<Book> books = bookDao.findAll();
        List<Book> books = bookRepository.findByCategoryId(category_id);
        model.addAttribute("books", books);
        return "book/list";
    }
}
