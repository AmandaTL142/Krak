package backend.service;

import backend.entity.Person;
import backend.repository.PersonRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PersonServiceTest {
    @Autowired
    static PersonRepository personRepository;


    static PersonService personService;

    static int person1Id, person2Id;



    @BeforeEach
    public void setup() {
        personRepository.deleteAll();
        Person Andrea = personRepository.save(new Person
                ("Andrea@mail.dk", "Andrea", "Andreasen", "112"));
        Person Isabel = personRepository.save(new Person
                ("Isabel@mail.dk", "Isabel", "Isabelsen", "911"));
        personService = new PersonService(personRepository);
    }

    @Test
    void getPeople() {

    }


    /*@Test
    public void updatePerson() throws Exception {
        PersonRequest personToEdit= new PersonRequest("alice@kk.dk", "alice", "Jensen", "+4599389004");
    }*/
}