package nt.logisticplatform.service;

import nt.logisticplatform.model.Person;
import nt.logisticplatform.model.PersonType;

import java.util.List;

public interface PersonService {
    List<Person> getAllPeopleByPersonType(PersonType personType);

    Person createPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(Long id);

    List<Person> getAllClients();

    List<Person> getAllEmployees();
}
