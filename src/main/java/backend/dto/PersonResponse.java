package backend.dto;

import backend.entity.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponse {
    int id;
    String email;
    String firstName;
    String lastName;
    String phone;

    public PersonResponse(Person person, boolean includeId, boolean includeContactInfo) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        if(includeId){
            this.id = id;
        }
        if(includeContactInfo){
            this.phone = phone;
            this.email = email;
        }
    }

    public PersonResponse(Person person) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
}
