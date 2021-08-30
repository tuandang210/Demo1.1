package com.service;

import com.repository.PersonMapper;
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
    public void insertPerson(Person person) {
        personMapper.insertPerson(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personMapper.updatePerson(person);
    }

    @Override
    public List<Person> findPersonByName(StringDto stringDto) {
        return personMapper.findPersonByName(stringDto);
    }

    @Override
    public void deletePersonById(Long id) {
        personMapper.deletePersonById(id);
    }
}
