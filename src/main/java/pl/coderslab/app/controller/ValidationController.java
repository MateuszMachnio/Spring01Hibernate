package pl.coderslab.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    private final Logger log = LoggerFactory.getLogger(ValidationController.class);
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }


    @GetMapping("/validate")
    public String validate(Model model) {
//        Book book = new Book();
//        book.setTitle("aaa");
//        book.setPages(1);
//        book.setDescription("desc");
//        Author author = new Author();
        Publisher publisher = new Publisher();
//        author.setEmail("mateusz93@gmail"); na mailu trzeba własną adnotację zrobić lub regex
//        author.setPesel("9303131241");
        publisher.setNip("2222222222");
        publisher.setRegon("222222222");
        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);

        if (!violations.isEmpty()) {
            model.addAttribute("violations", violations);

            for (ConstraintViolation<Publisher> violation : violations) {
                log.info("{} - {}", violation.getPropertyPath(), violation.getMessage());
            }
            return "/validation/notValid";
        }
        return "/validation/valid";
    }

}
