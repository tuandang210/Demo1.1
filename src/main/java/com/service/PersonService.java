package com.service;

import com.mapper.PersonMapper;
import com.model.Person;
import com.model.StringDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public List<Person> selectAllPerson() {
        return personMapper.selectAllPerson();
    }

    @Override
    public Person selectPersonById(Long personId) {
        return personMapper.selectPersonById(personId);
    }

    @Override
    public Person insertPerson(Person person) {
        return personMapper.insertPerson(person);
    }

    @Override
    public List<Person> findPersonByName(StringDto stringDto) {
        return personMapper.findPersonByName(stringDto);
    }
}
