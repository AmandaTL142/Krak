package backend.repository;

import backend.ConnectionManager;
import backend.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface HobbyRepo extends JpaRepository<Hobby, String> {

}
