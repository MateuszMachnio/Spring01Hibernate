package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.PersonDetails;
import pl.coderslab.app.repository.PersonDao;
import pl.coderslab.app.repository.PersonDetailsDao;

@Controller
public class PersonDetailsController {

    private final PersonDetailsDao personDetailsDao;
    private final PersonDao personDao;

    public PersonDetailsController(PersonDetailsDao personDetailsDao, PersonDao personDao) {
        this.personDetailsDao = personDetailsDao;
        this.personDao = personDao;
    }

    @RequestMapping("/person-details/add")
    @ResponseBody
    public String save() {
        PersonDetails personDetails = new PersonDetails("Mati", "Machnio", 5, "Tetka", "Miasteczko");
        personDetails.setPerson(personDao.findById(1));
        personDetailsDao.save(personDetails);
        return "Id dodanych danych osobowych to:" + personDetails.getId();
    }

    @RequestMapping("/person-details/get/{id}")
    @ResponseBody
    public String getPersonDetails(@PathVariable long id) {
        PersonDetails personDetailsById = personDetailsDao.findById(id);
        return personDetailsById.toString();
    }

    @RequestMapping("/person-details/update/{id}/{street}")
    @ResponseBody
    public String updatePersonDetails(@PathVariable long id, @PathVariable String street ) {
        PersonDetails personDetails = personDetailsDao.findById(id);
        personDetails.setStreet(street);
        personDetailsDao.update(personDetails);
        return personDetails.toString();
    }

    @RequestMapping("/person-details/delete/{id}")
    @ResponseBody
    public String deletePersonDetails(@PathVariable long id) {
        personDetailsDao.delete(personDetailsDao.findById(id));
        return "deleted";
    }
}
