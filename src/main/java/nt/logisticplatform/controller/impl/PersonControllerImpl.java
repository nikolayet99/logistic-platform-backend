package nt.logisticplatform.controller.impl;

import nt.logisticplatform.controller.PersonController;
import nt.logisticplatform.model.Person;
import nt.logisticplatform.model.PersonType;
import nt.logisticplatform.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonControllerImpl implements PersonController {
    @Autowired
    private PersonService personService;

    @Override
    public List<Person> getAllPeopleByPersonType(PersonType personType) {
        return personService.getAllPeopleByPersonType(personType);
    }

    @Override
    public Person createPerson(Person person) {
        return personService.createPerson(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personService.updatePerson(person);
    }

    @Override
    public void deletePerson(Long id) {
        personService.deletePerson(id);
    }
}
