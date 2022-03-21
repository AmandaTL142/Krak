package backend.repository;

import backend.entity.Hobby;
import backend.entity.HobbyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HobbyInfoRepo extends JpaRepository<HobbyInfo, Integer> {
    @Override
    List<HobbyInfo> findAll();

    //Få liste over HobbyInfo knyttet til en person
    List<HobbyInfo> findHobbyInfosByHasHobbies_Id(int id);

    //Få liste over HobbyInfo knyttet til en hobby
    List<HobbyInfo> findHobbyInfosByHobbyAdded(Hobby hobby);
}
