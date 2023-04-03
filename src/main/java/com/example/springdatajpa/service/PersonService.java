package com.example.springdatajpa.service;

import com.example.springdatajpa.model.PersonEntity;
import com.example.springdatajpa.repository.PersonRepository;
import com.example.springdatajpa.response.PaginatedPersonResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService {
    private final PersonRepository personRepository;
    PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public PaginatedPersonResponse getAll(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(Sort.Direction.ASC,"id"));
        Page<PersonEntity> persons = personRepository.findAll(pageable);
        PaginatedPersonResponse paginatedPersonResponse = new PaginatedPersonResponse(persons);
        return paginatedPersonResponse;
    }
}
