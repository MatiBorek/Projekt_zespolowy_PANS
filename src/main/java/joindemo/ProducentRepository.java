package joindemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProducentRepository extends JpaRepository<Producent, Long> {

    List<Producent> findByName(String name);
    


}
