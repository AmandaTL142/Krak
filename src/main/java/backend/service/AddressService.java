package backend.service;

import backend.dto.AddressRequest;
import backend.dto.AddressResponse;
import backend.dto.PersonRequest;
import backend.dto.PersonResponse;
import backend.entity.Address;
import backend.entity.Person;
import backend.error.Client4xxException;
import backend.repository.AddressRepository;
import backend.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    AddressRepository addressRepository;
    PersonRepository personRepository;


    //Constructor
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository=addressRepository;
    }


    public AddressResponse addAddress(AddressRequest body){
        if (addressRepository.addressExists(body)) {
            System.out.println("Address is already in database");
            return new AddressResponse(body);
        }
        Address addressNew = addressRepository.save(new Address(body));
        return new AddressResponse(addressNew);
    }

    public AddressResponse getAddressById(int id) throws Exception {
        Address address = addressRepository.findById(id).orElseThrow(()->new Client4xxException
                ("No address with this id exists"));
        return new AddressResponse(address);
    }

    public AddressResponse getAddressConnectedToPerson(String personId) throws Exception {
        Address address = personRepository.findById(personId).get().getConnectedAddress();
        //orElseThrow(()->new Client4xxException("No address with this id exists"));
        return new AddressResponse(address);
    }

    public AddressResponse updatePersonalAddress( AddressRequest addressToEdit, String email){
        Address personalAdressUpdated = personRepository.findById(email).get().getConnectedAddress();
        if(personRepository.emailExist(email)){
            personalAdressUpdated.setStreet(addressToEdit.getStreet());
            personalAdressUpdated.setZipCode(addressToEdit.getZipCode());
            personalAdressUpdated.setCity(addressToEdit.getStreet());
        }
        return new AddressResponse(addressRepository.save(personalAdressUpdated));

    }

    public void deletePersonalAddress(String email){
        Address personalAdress = personRepository.findById(email).get().getConnectedAddress();
        if(personRepository.emailExist(email)){
            addressRepository.delete(personalAdress);
        }

    }
}
