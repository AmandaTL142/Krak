package backend.service;

import backend.dto.HobbyInfoResponse;
import backend.entity.Hobby;
import backend.entity.HobbyInfo;
import backend.entity.Person;
import backend.repository.HobbyInfoRepo;
import backend.repository.HobbyRepo;
import backend.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HobbyInfoService {

    HobbyInfoRepo hobbyInfoRepo;
    HobbyRepo hobbyRepo;
    PersonRepository personRepository;
    Person person;

    public HobbyInfoService( HobbyInfoRepo hobbyInfoRepo, PersonRepository personRepository){
        this.hobbyInfoRepo= hobbyInfoRepo;
        this.personRepository=personRepository;
    }
/*
    public List<HobbyInfo> getPersonalHobbyList(String email){
        personRepository.getById(email).get;


        person.getEmail()

        return hobbyInfoRepo.findAll();
    }

 */

    public HobbyInfoResponse getHobbyInfo(int id) throws Exception {
        return new HobbyInfoResponse(hobbyInfoRepo.findById(id).orElseThrow(()-> new Exception("Could not find Hobby")));
    }

    //Denne metode opretter en ny HobbyInfo, der forbinder en hobby med en person.
    public HobbyInfo connectHobbyToPerson(Person person, Hobby hobby){
        HobbyInfo newHobbyInfo = hobbyInfoRepo.save(new HobbyInfo(hobby, person));

        return newHobbyInfo;
    }

    //
    public void getPersonsHobbies(Person person){

    }

    public void deleteHobbyInfo(int id){
        hobbyInfoRepo.deleteById(id);
    }


    /*En liste skal være tilknyttet en bestemt mail
    Ved at have indtastet/opgivet en mail er det muligt at få vist/oprette en hobbyliste
    samtidig skal det være muligt at redigere i denne liste, altså tilføje/fjerne hobbyer*/

}
