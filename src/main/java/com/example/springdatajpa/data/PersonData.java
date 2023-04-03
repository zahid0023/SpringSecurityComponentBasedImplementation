package com.example.springdatajpa.data;

import com.example.springdatajpa.model.PersonEntity;
import com.github.javafaker.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonData {
        private Long personId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private AddressData address;

        public PersonData(PersonEntity personEntity){
                this.personId = personEntity.getId();
                this.firstName = personEntity.getFirstName();
                this.lastName = personEntity.getLastName();
                this.phoneNumber = personEntity.getPhoneNumber();
                this.address = new AddressData(personEntity.getAddress().getId(),
                        personEntity.getAddress().getAddress(),
                        personEntity.getAddress().getCity(),
                        personEntity.getAddress().getState(),
                        personEntity.getAddress().getZip());
        }
}
