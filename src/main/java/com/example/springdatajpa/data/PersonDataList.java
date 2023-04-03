package com.example.springdatajpa.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDataList {
    private List<PersonData> personDataList;

    public PersonDataList(List<PersonData> personDataList){
        this.personDataList = personDataList;
    }

}
