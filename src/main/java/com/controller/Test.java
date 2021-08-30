package com.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Person;
import com.model.StringDto;
import com.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class Test {
    @Autowired
    private IPersonService personService;

    @PostMapping(value = "/people2")
    public ResponseEntity<String> showListAll(@RequestParam String name, @RequestParam String identityCard) {
        List<Person> people = new ArrayList<>();
        StringDto stringDto = new StringDto('%' + name + '%', '%' + identityCard + '%');
        if (name.equals("") && identityCard.equals("")) {
            people = personService.selectAllPerson();
        } else {
            people = personService.findPersonByName(stringDto);
        }

        Gson gson = new GsonBuilder().create();
        String listPerson = gson.toJson(people);
        listPerson = "{\"Result\":\"OK\",\"Records\":" + listPerson + "}";
        return new ResponseEntity<>(listPerson, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addPerson(@RequestParam String id, @RequestParam String name, @RequestParam String identityCard, @RequestParam String ward, @RequestParam String district) {
        Long newId = Long.parseLong(id);
        Person person = new Person(newId, name, identityCard, ward, district);
        personService.insertPerson(person);
        Gson gson = new GsonBuilder().create();
        String addPerson = gson.toJson(person);
        addPerson = "{\"Result\":\"OK\",\"Record\":" + addPerson + "}";
        return new ResponseEntity<>(addPerson, HttpStatus.CREATED);
    }

    @PostMapping(value = "/update}")
    public ResponseEntity<String> updatePerson(@RequestParam String id, @RequestParam String name, @RequestParam String identityCard, @RequestParam String ward, @RequestParam String district){
        Long newId = Long.parseLong(id);
        Person person = new Person(newId, name, identityCard, ward, district);
        Person person1 = personService.updatePerson(person);
        Gson gson = new GsonBuilder().create();
        String updatePerson = gson.toJson(person1);
        updatePerson = "{\"Result\":\"OK\",\"Record\":" + updatePerson + "}";
        return new ResponseEntity<>(updatePerson, HttpStatus.OK);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> deletePerson(@RequestParam String id){
        Long newId = Long.parseLong(id);
        personService.deletePersonById(newId);
        Gson gson = new GsonBuilder().create();
        String deletePerson = gson.toJson(newId);
        deletePerson = "{\"Result\":\"OK\"}";
        return new ResponseEntity<>(deletePerson, HttpStatus.NO_CONTENT);
    }
}
