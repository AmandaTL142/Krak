package backend.api;

import backend.dto.HobbyInfoResponse;
import backend.dto.HobbyResponse;
import backend.dto.PersonRequest;
import backend.dto.PersonResponse;
import backend.entity.Hobby;
import backend.entity.HobbyInfo;
import backend.entity.Person;
import backend.service.HobbyInfoService;
import backend.service.HobbyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/personalHobbies")
public class HobbyInfoController {

    HobbyInfoService hobbyInfoService;

    //Nedenstående skal ændres til, at indput er PersonRequest og HobbyRequest output er HobbyInfoRequest
    @PostMapping
    public HobbyInfo addHobbyInfo(@RequestBody Person person, Hobby hobby) throws Exception {
        return hobbyInfoService.connectHobbyToPerson(person, hobby);
    }

    @DeleteMapping("/{id}")
    public void deleteHobbyInfo(@PathVariable int id) {
        hobbyInfoService.deleteHobbyInfo(id);
    }


/*
    HobbyInfoService;

    @GetMapping
    public List<HobbyInfoResponse> getHobbies() {
        return HobbyInfoService.;
    }

    @GetMapping("/{name}")
    public HobbyResponse getHObby(@PathVariable String name) throws Exception {
        return hobbyService.getHobby(name);
    }

 */
}
