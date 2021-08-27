package com.service;

import com.model.Person;
import com.model.StringDto;

import java.util.List;

public interface IPersonService {

    List<Person> selectAllPerson();

    Person selectPersonById(Long personId);

    Person insertPerson(Person person);

    List<Person> findPersonByName(StringDto stringDto);

}
