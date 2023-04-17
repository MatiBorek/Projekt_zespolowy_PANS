package Database.repository;

import Database.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByName(String name);

    @Transactional
    @Modifying
    @Query("update Cart c set c.name = ?1 where c.id = ?2")
    void updateCartName(String name, Long id);





}
