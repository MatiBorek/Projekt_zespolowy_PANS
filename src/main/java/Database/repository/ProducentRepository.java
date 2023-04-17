package Database.repository;

import Database.entity.Producent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProducentRepository extends JpaRepository<Producent, Long> {

    List<Producent> findByName(String name);

    @Transactional
    @Modifying
    @Query("update Producent p set p.name = ?1 where p.id = ?2")
    void updateProducentName(String name, Long id);





}
