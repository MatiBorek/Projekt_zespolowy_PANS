package Database.repository;

import Database.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name);

    @Transactional
    @Modifying
    @Query("update Category c set c.name = ?1 where c.id = ?2")
    void updateCategoryName(String name, Long id);





}
