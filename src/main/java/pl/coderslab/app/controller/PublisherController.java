package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.repository.AuthorDao;
import pl.coderslab.app.repository.BookDao;
import pl.coderslab.app.repository.PublisherDao;

import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/list")
    public String showPublishers(Model model) {
        model.addAttribute("publishers", publisherDao.getAll());
        return "/publisher/list";
    }

    @GetMapping("/form")
    public String addPublisher(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "/publisher/form";
    }

    @PostMapping("/form")
    public String addingPublisher(Publisher publisher) {
        publisherDao.savePublisher(publisher);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("publisher", publisherDao.findById(id));
        return "/publisher/edit";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(Publisher publisher) {
        publisherDao.update(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        model.addAttribute("publisher", publisherDao.findById(id));
        return "publisher/delete";
    }

    @PostMapping("delete/{id}")
    public String deleteConfirmation(@PathVariable Long id) {
        publisherDao.delete(publisherDao.findById(id));
        return "redirect:/publisher/list";
    }










    @RequestMapping("/add")
    @ResponseBody
    public String save() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisherDao.savePublisher(publisher);
        return "Id dodanego publishera to:" + publisher.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name ) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }
}
