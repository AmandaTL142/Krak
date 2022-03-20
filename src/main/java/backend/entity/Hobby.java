package backend.entity;

import backend.dto.HobbyRequest;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor

public class Hobby {
    @Id
    String name;

    String link;
    String category;
    String inOut;

    /*@OneToMany(mappedBy = "hobbyWithInfo")
    private Set<HobbyInfo> hobbies = new HashSet<>();*/


    public Hobby(HobbyRequest body){
        this.name = body.getName();
        this.link = body.getLink();
        this.category = body.getCategory();
        this.inOut = body.getInOut();
    }

    public Hobby(String name, String link, String category, String inOut) {
        this.name = name;
        this.link = link;
        this.category = category;
        this.inOut = inOut;
    }

}
