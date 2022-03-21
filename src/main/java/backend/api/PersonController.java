package backend.api;

import backend.dto.PersonRequest;
import backend.dto.PersonResponse;
import backend.entity.Hobby;
import backend.entity.HobbyInfo;
import backend.entity.Person;
import backend.repository.HobbyInfoRepo;
import backend.repository.HobbyRepo;
import backend.repository.PersonRepository;
import backend.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController


@RequestMapping("api/krak")
public class PersonController {
    PersonService personService;
    PersonRepository personRepository;
    HobbyInfoRepo hobbyInfoRepo;
    HobbyRepo hobbyRepo;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public PersonResponse addPerson(@RequestBody PersonRequest body) throws Exception {
        return personService.addPerson(body);
    }

    @PutMapping("/{id}")
    public PersonResponse updatePerson(@RequestBody PersonRequest body, @PathVariable int id){
        return personService.updatePerson(body,id);
    }

    @GetMapping
    public List<PersonResponse> getPeople (){
        return personService.getPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson (@PathVariable int id){
        return personService.getPerson(id);
    }

    //Dette endpoint returnerer en liste over hobbyer, der er tilknyttet en person
    @GetMapping("/personalhobbies/{id}")
    public List<Hobby> getPersonsHobbies (@PathVariable int id){
        List<HobbyInfo> hobbyInfos = hobbyInfoRepo.findHobbyInfosByHasHobbies_Id(id);
        List<Hobby> hobbies = null;

        for (HobbyInfo hobbyInfo: hobbyInfos) {
            hobbies.add(hobbyRepo.findHobbyByHobbyInfos(hobbyInfo));
        }

        return hobbies;
    }

    //Dette endpoint returnerer alle personer, der er tilknyttet en hobby.
    @GetMapping("/people/{name}")
    public List<Person> getPeopleConnectedToHobby (@PathVariable String name){
        Hobby hobby = hobbyRepo.getById(name); //Skal ændres

        List<HobbyInfo> hobbyInfos = hobbyInfoRepo.findHobbyInfosByHobbyAdded(hobby);

        List<Person> people = null;

        for (HobbyInfo hobbyInfo: hobbyInfos) {
            people.add(personRepository.findPersonByHobbyInfos(hobbyInfo));
        }

        return people;
    }


    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable int id) {
        personService.deletePerson(id);
    }

}

