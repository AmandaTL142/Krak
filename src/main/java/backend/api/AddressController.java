package backend.api;

import backend.dto.AddressRequest;
import backend.dto.AddressResponse;
import backend.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

@RequestMapping("api/address")
public class AddressController {

    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping()
    public AddressResponse addPersonalAddress(@RequestBody AddressRequest body){
        return addressService.addAddress(body);
    }

    @PutMapping
    public AddressResponse updatePersonalAdsdress(@RequestBody AddressRequest body, String email){
        return addressService.updatePersonalAddress(body, email);
    }

    @DeleteMapping
    public void deletePersonalAddress(String email){
        addressService.deletePersonalAddress(email)Ad;
    }

}
