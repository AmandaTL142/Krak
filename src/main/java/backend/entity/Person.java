package backend.entity;

import lombok.*;
import backend.dto.PersonRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String email;
            //@Column(length = 320)


    String firstName;

    String lastName;

    @Column(length = 20)
    String phone;

    @ManyToOne
    Address connectedAddress;


    public Person(PersonRequest body) {
        this.email = body.getEmail();
        this.firstName = body.getFirstName();
        this.lastName = body.getFirstName();
        this.phone = body.getPhone();
    }

    public Person(String email, String firstName, String lastName, String phone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    @OneToMany(mappedBy = "hasHobbies", fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)

    private Set<HobbyInfo> hobbyInfos = new HashSet<>();

    public void addHobby(HobbyInfo hi){
        hobbyInfos.add(hi);
    }

}

