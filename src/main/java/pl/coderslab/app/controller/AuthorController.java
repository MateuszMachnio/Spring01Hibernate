package pl.coderslab.app.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.repository.AuthorDao;
import pl.coderslab.app.repository.BookDao;

import javax.transaction.Transactional;
import java.util.List;

@RequestMapping("/author")
@Controller
public class AuthorController {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    
    public AuthorController(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.getAll();
    }

    @ModelAttribute("books")
    public List<Book> books() {
        return bookDao.findAll();
    }

    @RequestMapping("/list")
    public String showAuthors() {
        return "/author/list";
    }

    @GetMapping("/form")
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "/author/form";
    }

    @PostMapping("/form")
    public String addingAuthor(Author author) {
        authorDao.saveAuthor(author);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorDao.findByIdWithBooks(id));
        return "author/edit";
    }

//    @Transactional
//    @PostMapping("/edit")
//    public String editProcess(Author author) {
//        Author author1 = authorDao.findByIdWithBooks(author.getId());
//        author1.getBooks().forEach(book -> book.removeAuthor(author1));
//        author.getBooks().forEach(book -> bookDao.findByIdWithAuthors(book.getId()).addAuthor(author));
//        authorDao.update(author);
//        return "redirect:/author/list";
//    }

    @Transactional
    @PostMapping("/edit")
    public String editProcess(Author author) {
        Author author1 = authorDao.findByIdWithBooks(author.getId());
        author1.removeBooks();
        Hibernate.initialize(author1.saveBooks(author.getBooks()));;
        authorDao.update(author);
        return "redirect:/author/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorDao.findByIdWithBooks(id));
        return "author/delete";
    }

    @PostMapping("delete/{id}")
    public String deleteConfirmation(@PathVariable Long id) {
        authorDao.delete(authorDao.findById(id));
        return "redirect:/author/list";
    }
    
    @RequestMapping("/add")
    @ResponseBody
    public String save() {
        Author author = new Author();
        author.setFirstName("Javaman2");
        author.setLastName("ciekawy");
//        author.setAuthor("Bruce Eckel");
        authorDao.saveAuthor(author);
        return "Id dodanego autora to:" + author.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/update/{id}/{firstName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName ) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        authorDao.update(author);
        return author.toString();
    }

//    @RequestMapping("/delete/{id}")
//    @ResponseBody
//    public String deleteAuthor(@PathVariable long id) {
//        Author author = authorDao.findById(id);
//        authorDao.delete(author);
//        return "deleted";
//    }


}
