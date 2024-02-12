package nt.logisticplatform.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nt.logisticplatform.exception.ApiClientRuntimeException;
import nt.logisticplatform.model.Person;
import nt.logisticplatform.model.PersonType;
import nt.logisticplatform.repository.PersonRepository;
import nt.logisticplatform.service.PersonService;
import nt.logisticplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class PersonServiceImpl implements PersonService {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserService userService;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Person> getAllPeopleByPersonType(PersonType personType) {
        return personType.equals(PersonType.CLIENT) ? getAllClients() : getAllEmployees();
    }

    @Override
    public Person createPerson(Person person) {
        validatePerson(person);
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        validatePerson(person);
        Person existingPerson = entityManager.find(Person.class, person.getId());
        if (existingPerson == null)
            throw new IllegalArgumentException("Invalid person provided");

        existingPerson = person;
        return entityManager.merge(existingPerson);
    }

    @Override
    public void deletePerson(Long id) {
        Person existingPerson = entityManager.find(Person.class, id);
        if (existingPerson == null)
            throw new IllegalArgumentException("Invalid person provided");

        userService.deleteUserByPersonId(existingPerson.getId());
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAllClients() {
        return personRepository.findByPersonType(PersonType.CLIENT);
    }

    @Override
    public List<Person> getAllEmployees() {
        return personRepository.findByPersonType(PersonType.EMPLOYEE);
    }

    private void validatePerson(Person person) {
        String address = person.getAddress();
        if (address == null || address.isEmpty())
            throw new ApiClientRuntimeException("Invalid address provided.");

        PersonType personType = person.getPersonType();
        if (personType == null)
            throw new ApiClientRuntimeException("Invalid person type provided.");

        String name = person.getName();
        if (name == null || name.isEmpty())
            throw new ApiClientRuntimeException("Invalid person name provided.");

        String email = person.getEmail();
        if (!isValidEmail(email))
            throw new ApiClientRuntimeException("Invalid person email provided.");

        String phoneNumber = person.getPhoneNumber();
        if (phoneNumber == null || phoneNumber.isEmpty() || !containsOnlyNumbers(phoneNumber)
                || (phoneNumber.startsWith("+") && !containsOnlyNumbers(phoneNumber.substring(1))) ||
                !containsOnlyNumbers(phoneNumber))
            throw new ApiClientRuntimeException("Invalid person phone number provided.");
    }

    private boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && PATTERN.matcher(email).matches();
    }

    private boolean containsOnlyNumbers(String s) {
        for (char c : s.toCharArray())
            if (!Character.isDigit(c))
                return false;

        return true;
    }
}
