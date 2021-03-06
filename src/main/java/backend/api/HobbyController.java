package backend.api;

import backend.dto.HobbyResponse;
import backend.repository.HobbyRepo;
import backend.service.HobbyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("api/hobbies")
public class HobbyController {

    HobbyService hobbyService;

    @GetMapping
    public List<HobbyResponse> getHobbies (){
        return hobbyService.getHobbies();
    }
    @GetMapping("/{name}")
    public HobbyResponse getHObby(@PathVariable String name) throws Exception{
        return hobbyService.getHobby(name);
    }
}
