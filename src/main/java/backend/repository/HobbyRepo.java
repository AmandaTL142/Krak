package backend.repository;

import backend.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepo extends JpaRepository<Hobby, String> {

}
