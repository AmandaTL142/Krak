package backend.api;

import backend.entity.Person;
import backend.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    //Do something here

    @Autowired
    private ObjectMapper objectMapper;

    static int AndreaId, IsabelId;

    @BeforeEach
    public void setup() {
        personRepository.deleteAll();
        AndreaId = personRepository.save(new Person("Andrea@mail.dk", "Andrea", "Andreasen", "112")).getId();
        IsabelId = personRepository.save(new Person("Isabel@mail.dk", "Isabel", "Isabelsen", "911")).getId();
    }

    @Test
    void getPeople() {
    }


    @Test
    void addPerson() {
    }

    @Test
    void updatePerson() {
    }

    @Test
    void testGetPeople() {
    }

    @Test
    void getPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/krak/" + AndreaId)
                        .accept(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(AndreaId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mail").value("Andrea@mail.dk"));
    }

    @Test
    void getPersonsHobbies() {
    }

    @Test
    void getPeopleConnectedToHobby() {
    }

    @Test
    void deleteMember() {
    }
/*
    @Test
    public void testAllCars() throws Exception {
        String model = "$[?(@.model == '%s')]";
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                //One way of testing this
                .andExpect(MockMvcResultMatchers.jsonPath(model, "Focus").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(model, "Vitara").exists())
                //Another way
                .andExpect(MockMvcResultMatchers.content().string(containsString("Focus")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Vitara")));

    }

    @Test
    public void testAddCar() throws Exception {
        CarRequest newCar = new CarRequest("WW", "Polo", 200, 10);
       // System.out.println("XXXXXXX"+objectMapper.writeValueAsString(newCar));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cars")
                        .contentType("application/json")
                        .accept("application/json")
                        .content(objectMapper.writeValueAsString(newCar)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        //Verify that it actually ended in the database
        assertEquals(3, carRepository.count());

    }


    // @Test
    public void editCar() throws Exception {}

    @Test
    void deleteCar() throws Exception {}

 */
}
