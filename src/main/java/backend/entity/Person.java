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
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


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

    public Person(String email, String firstName, String lastName, String phone, Address connectedAddress){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.connectedAddress=connectedAddress;
    }

    @OneToMany(mappedBy = "hasHobbies", fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)

    private Set<HobbyInfo> hobbyInfos = new HashSet<>();

    public void addHobby(HobbyInfo hi){
        hobbyInfos.add(hi);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", connectedAddress=" + connectedAddress +
                ", hobbyInfos=" + hobbyInfos +
                '}';
    }
}

