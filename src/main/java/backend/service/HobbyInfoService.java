package backend.service;

import backend.repository.HobbyInfoRepo;
import backend.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class HobbyInfoService {

    HobbyInfoRepo hobbyInfoRepo;
    PersonRepository personRepository;

    public HobbyInfoService(){}

    /*
      public ReservationService(ReservationReporsitory reservationReporsitory, CarRepository carRepository){
        this.reservationReporsitory= reservationReporsitory;
        this.carRepository=carRepository;
    }
    */

}
