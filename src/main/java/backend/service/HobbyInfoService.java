package backend.service;

import backend.dto.HobbyInfoResponse;
import backend.entity.HobbyInfo;
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

    public HobbyInfoService( HobbyInfoRepo hobbyInfoRepo, PersonRepository personRepository){
        this.hobbyInfoRepo= hobbyInfoRepo;
        this.personRepository=personRepository;
    }

    public List<HobbyInfo> getAllHobbyInfo(){
        return hobbyInfoRepo.findAll();
    }

    public HobbyInfoResponse getHobbyInfo(String id) throws Exception {
        return new HobbyInfoResponse(hobbyInfoRepo.findById(id).orElseThrow(()-> new Exception("Could not find Hobby")));
    }

}
