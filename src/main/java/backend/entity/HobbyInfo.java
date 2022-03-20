package backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class HobbyInfo {

    @Id
    private String id;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime hobbyAdded;

    @ManyToOne
    Hobby hobbyObject;

    @ManyToOne
    Person hasHobbies;


    public HobbyInfo(String id,LocalDateTime date, Hobby hobbyObject, Person hasHobbies){
        this.hobbyAdded= date;
        this.hasHobbies=hasHobbies;
        this.hobbyObject =hobbyObject;
        hobbyObject.addHobbyInfos(this);
        hasHobbies.addHobby(this);

    }
}
