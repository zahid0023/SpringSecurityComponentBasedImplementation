package com.example.springdatajpa.response;

import com.example.springdatajpa.data.PersonData;
import com.example.springdatajpa.data.PersonDataList;
import com.example.springdatajpa.model.PersonEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PaginatedPersonResponse {
    List<PersonData> personDataList;
    PersonDataList persons;
    Long totalElements;
    int pageNumber;
    int pageSize;
    boolean empty;
    public PaginatedPersonResponse(Page<PersonEntity> personEntities){
        personDataList = new ArrayList<>();
        personEntities.forEach(personEntity -> {
            PersonData personData = new PersonData(personEntity);
            personDataList.add(personData);
        });
        persons = new PersonDataList(personDataList);
        this.totalElements = personEntities.getTotalElements();
        this.pageNumber = getPageNumber();
        this.pageSize = personEntities.getSize();
        this.empty = personEntities.isEmpty();


    }
}
