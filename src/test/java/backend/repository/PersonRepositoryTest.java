package backend.repository;

import backend.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {


    @Autowired
    PersonRepository personRepository;

    @Autowired
    private ObjectMapper objectMapper;

    static int AndreaId, IsabelId;

    @BeforeEach
    public void setup() {
        personRepository.deleteAll();
        AndreaId = personRepository.save(new Person
                ("Andrea@mail.dk", "Andrea", "Andreasen", "112")).getId();
        IsabelId = personRepository.save(new Person
                ("Isabel@mail.dk", "Isabel", "Isabelsen", "911")).getId();
    }


    @Test
    void testFindPersonById() {
        Person Andrea = personRepository.findById(AndreaId).orElse(null);
        assertEquals("Andrea@mail.dk", Andrea.getEmail());
    }

    @Test
    void emailExist() {
    }

    @Test
    void findPersonByHobbyInfos() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findPersonById() {
        Person person = personRepository.findPersonById(1);
        assertEquals("Andrea@mail.dk", person.getEmail());
    }
}