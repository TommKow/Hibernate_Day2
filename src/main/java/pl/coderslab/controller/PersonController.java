package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.person.PersonDao;
import pl.coderslab.model.person.Person;

@Controller

public class PersonController {
    @Autowired
    PersonDao personDao;

    @RequestMapping(value = "/personForm", method = RequestMethod.GET)
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }
    @RequestMapping(value = "/personForm", method = RequestMethod.POST)
    @ResponseBody
    public String personRegistered(@RequestParam String login, @RequestParam String email, @RequestParam String password, Model model) {
        Person person = new Person(login, email, password);
        model.addAttribute("person", person);
        personDao.savePerson(person);
        return "succes";
    }
}
