package com.example.springdatajpa.repository;

import com.example.springdatajpa.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<PersonEntity,Long> {

}
