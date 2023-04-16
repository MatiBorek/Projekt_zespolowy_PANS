package joindemo.repository;

import joindemo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByFname(String name);

    @Transactional
    @Modifying
    @Query("update Client c set c.fname = ?1 where c.id = ?2")
    void updateClientName(String fname, Long id);





}
