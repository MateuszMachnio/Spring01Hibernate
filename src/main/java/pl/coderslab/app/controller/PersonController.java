package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Person;
import pl.coderslab.app.repository.PersonDao;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/form")
    public String form() {
        return "person/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processForm(@RequestParam String login, @RequestParam String password, @RequestParam String email) {
        Person person = new Person(login, password, email);
        personDao.savePerson(person);
        return "Id dodanej osoby to:" + person.getId();
    }

    @GetMapping("/formBind")
    public String formBinding(Model model) {
        model.addAttribute("person", new Person());
        return "person/formBind";
    }

    @PostMapping("/formBind")
    @ResponseBody
    public String processFormBinding(Person person) {
        personDao.savePerson(person);
        return "Id dodanej osoby to:" + person.getId();
    }
}
