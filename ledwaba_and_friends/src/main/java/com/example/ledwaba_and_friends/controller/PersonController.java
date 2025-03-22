package com.example.ledwaba_and_friends.controller;



import com.example.ledwaba_and_friends.model.Person;
import com.example.ledwaba_and_friends.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "http://localhost:4200") 
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/persons/add")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
        @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person savedPerson = personService.savePerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }
}

