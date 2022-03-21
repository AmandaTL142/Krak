package backend.service;


import backend.dto.HobbyResponse;
import backend.entity.Hobby;
import backend.repository.HobbyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {

    HobbyRepo hobbyRepo;
    HobbyResponse hobbyResponse;

    public HobbyService (HobbyRepo hobbyRepo){
        this.hobbyRepo = hobbyRepo;
    }

    public List<HobbyResponse> getHobbies(){
        List<Hobby> hobbies= hobbyRepo.findAll();
        return hobbyResponse.getHobbiesEntities(hobbies);
    }

    public HobbyResponse getHobby(String name) throws Exception{
        Hobby hobby= hobbyRepo.findById(name).orElseThrow(()-> new Exception("do not exist"));

        return new HobbyResponse(hobby);
    }

}
