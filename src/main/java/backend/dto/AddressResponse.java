package backend.dto;

import backend.entity.Address;

public class AddressResponse {

    String street;
    String additionalInfo;
    String zipCode;
    String city;

    public AddressResponse(AddressRequest body) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.zipCode = zipCode;
        this.city = city;
    }

    public AddressResponse(Address address) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.zipCode = zipCode;
        this.city = city;
    }
}
