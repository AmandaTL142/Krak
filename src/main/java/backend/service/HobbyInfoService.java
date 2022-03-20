package backend.service;

import backend.dto.HobbyInfoResponse;
import backend.entity.HobbyInfo;
import backend.entity.Person;
import backend.repository.HobbyInfoRepo;
import backend.repository.HobbyRepo;
import backend.repository.PersonRepository;
import org.springframework.stereotype.Service;

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


    public HobbyInfoResponse getHobbyInfo(String id) throws Exception {
        return new HobbyInfoResponse(hobbyInfoRepo.findById(id).orElseThrow(()-> new Exception("Could not find Hobby")));
    }

    /*En liste skal være tilknyttet en bestemt mail
    Ved at have indtastet/opgivet en mail er det muligt at få vist/oprette en hobbyliste
    samtidig skal det være muligt at redigere i denne liste, altså tilføje/fjerne hobbyer*/

}
