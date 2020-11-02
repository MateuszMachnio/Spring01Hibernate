package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.classes.Student;
import pl.coderslab.app.entity.Person;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("cycling", "skiing", "swimming", "jumping", "fishing");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "PHP", "JavaScript", "Ruby", "Python");
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processForm(Student student) {
        return student.toString();
    }
}
