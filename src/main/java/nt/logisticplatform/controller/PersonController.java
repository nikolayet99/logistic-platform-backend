package nt.logisticplatform.controller;

import io.swagger.v3.oas.annotations.Operation;
import nt.logisticplatform.model.Person;
import nt.logisticplatform.model.PersonType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/people")
public interface PersonController {
    @GetMapping("/all/{personType}")
    @Operation(tags = {"Person"}, summary = "Get all people by type")
    List<Person> getAllPeopleByPersonType(@PathVariable PersonType personType);

    @PostMapping
    @Transactional
    @Operation(tags = {"Person"}, summary = "Create person")
    Person createPerson(@RequestBody Person person);

    @PutMapping
    @Transactional
    @Operation(tags = {"Person"}, summary = "Update person")
    Person updatePerson(@RequestBody Person person);

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(tags = {"Person"}, summary = "Delete person by person id")
    void deletePerson(@PathVariable Long id);
}
