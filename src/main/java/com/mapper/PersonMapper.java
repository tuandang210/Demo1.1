package com.mapper;

import com.model.Person;
import com.model.StringDto;

import java.util.List;

public interface PersonMapper {
    List<Person> selectAllPerson();

    Person selectPersonById(Long personId);

    Person insertPerson(Person person);

    List<Person> findPersonByName(StringDto stringDto);
}
