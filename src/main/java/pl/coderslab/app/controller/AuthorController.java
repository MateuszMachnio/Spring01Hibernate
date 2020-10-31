package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.repository.AuthorDao;
import pl.coderslab.app.repository.AuthorDao;

@Controller
public class AuthorController {

    private final AuthorDao authorDao;
    
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    
    @RequestMapping("/author/add")
    @ResponseBody
    public String save() {
        Author author = new Author();
        author.setFirstName("Javaman");
//        author.setAuthor("Bruce Eckel");
        authorDao.saveAuthor(author);
        return "Id dodanego autora to:" + author.getId();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{firstName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName ) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }
}
