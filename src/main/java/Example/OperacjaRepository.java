package Example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;


public interface OperacjaRepository extends JpaRepository<Operacja, Long> {

    List<Operacja> findByValueINGreaterThanEqual(double valueIN);

    List<Operacja> findByValueINGreaterThanAndValueINLessThan(double ValueIN1,double ValueIN2);

    @Query("select walutaIN, sum(prowizja) from Operacja group by  walutaIN")
    List<Tuple> SumProwizja();
}
