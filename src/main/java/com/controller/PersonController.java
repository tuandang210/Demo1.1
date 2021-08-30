package com.controller;

import com.model.Person;
import com.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@CrossOrigin
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping("/")
    public ModelAndView showList() {
        Iterable<Person> people = personService.selectAllPerson();
        return new ModelAndView("/index", "people", people);
    }

    @GetMapping("/people/{id}")
    public ModelAndView showDetailPerson(@PathVariable Long id) {
        Person person = personService.selectPersonById(id);
        if (person == null) {
            return new ModelAndView("/error");
        }
        return new ModelAndView("/detail", "person", person);
    }
}
