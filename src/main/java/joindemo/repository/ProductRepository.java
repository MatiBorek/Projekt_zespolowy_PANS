package joindemo.repository;

import joindemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    @Transactional
    @Modifying
    @Query("update Product p set p.name = ?1 where p.id = ?2")
    void updateProductName(String name, Long id);





}
