package backend.api;

import backend.dto.HobbyResponse;
import backend.entity.Hobby;
import backend.entity.HobbyInfo;
import backend.repository.HobbyRepo;
import backend.service.HobbyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("api/hobbies")
public class HobbyController {

    HobbyService hobbyService;
    HobbyRepo hobbyRepo;

    @GetMapping
    public List<HobbyResponse> getHobbies (){
        return hobbyService.getHobbies();
    }
    @GetMapping("/{name}")
    public HobbyResponse getHobby(@PathVariable String name) throws Exception{
        return hobbyService.getHobby(name);
    }

    //Dette endpoint returnerer den hobby, der er tilknyttet en hobbInfo. Skal nok ikke bruges, men demonstrerer metoden.
    @GetMapping
    public Hobby getPersonsHobbies (@PathVariable HobbyInfo hobbyInfo){
        return hobbyRepo.findHobbyByHobbyInfos(hobbyInfo);
    }


}
