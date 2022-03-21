package backend.configuration;

import backend.entity.Hobby;
import backend.entity.Person;
import backend.repository.HobbyRepo;
import backend.repository.PersonRepository;
import backend.service.HobbyInfoService;
import backend.service.PersonService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {

    PersonRepository memberRepository;
    PersonService personService;
    HobbyInfoService hobbyInfoService;
    HobbyRepo hobbyRepo;

    public MakeTestData(PersonRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void makeMembers(){
        Person m1 = memberRepository.save(new Person("amanda@amanda.dk", "Amanda", "Amandasen", "70121416"));
        Person m2 = memberRepository.save(new Person("casper@casper.co.uk", "Casper", "Caspersen", "88888888"));

        /*
        Hobby h1 = hobbyRepo.save(new Hobby("test", "test", "test", "test"));

        hobbyInfoService.connectHobbyToPerson(m1, h1);

         */

        System.out.println("--------------Testdata kørt--------------");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        makeMembers();

    }
}

