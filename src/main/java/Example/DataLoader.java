package Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


//Dodanie osob do repozytorium na samym poczatku
@Component
public class DataLoader implements ApplicationRunner {

    private OperacjaRepository operacjaRepository;

    @Autowired
    public DataLoader(OperacjaRepository operacjaRepository) {
        this.operacjaRepository = operacjaRepository;
    }

    public void run(ApplicationArguments args) {
        
        operacjaRepository.save(new Operacja("Euro (4,78)",5.0,"PLN",25.0,1.0));
        operacjaRepository.save(new Operacja("Dollar (4,84)",5.0,"PLN",25.0,2.2));
        operacjaRepository.save(new Operacja("PLN",15.0,"Euro (4,78)",3.0,3.3));
        operacjaRepository.save(new Operacja("PLN",16.0,"Dollar (4,84)",4.0,5.4));
    }
}