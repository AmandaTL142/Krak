package backend.repository;

import backend.entity.Hobby;
import backend.entity.HobbyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HobbyRepo extends JpaRepository<Hobby, String> {

    Hobby findHobbyByHobbyInfos(HobbyInfo hobbyInfo);

}
