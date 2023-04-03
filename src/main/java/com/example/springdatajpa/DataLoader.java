package com.example.springdatajpa;

import com.example.springdatajpa.model.AddressEntity;
import com.example.springdatajpa.model.PersonEntity;
import com.example.springdatajpa.service.PersonService;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataLoader implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private PersonService personService;
    private final Faker faker;

    DataLoader(PersonService personService, Faker faker) {
        this.personService = personService;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading data from database........");
        List<PersonEntity> persons = IntStream.rangeClosed(1, 100).mapToObj(i -> new PersonEntity(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                new AddressEntity(
                        faker.address().streetAddress(),
                        faker.address().city(),
                        faker.address().state(),
                        faker.address().zipCode()
                )
        )).toList();
    }
}
