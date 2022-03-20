package backend.repository;

import backend.entity.HobbyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyInfoRepo extends JpaRepository<HobbyInfo, String> {
}
