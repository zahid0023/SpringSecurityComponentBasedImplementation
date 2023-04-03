package com.example.springdatajpa.controller;

import com.example.springdatajpa.response.PaginatedPersonResponse;
import com.example.springdatajpa.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/people")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "get-all", method = RequestMethod.GET)
    public ResponseEntity<PaginatedPersonResponse> getPeople(@RequestParam int pageNumber, @RequestParam int pageSize){
        return new ResponseEntity<>(personService.getAll(pageNumber,pageSize), HttpStatus.OK);
    }
}
