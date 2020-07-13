package ru.breadwinner.service.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.breadwinner.service.category.Category;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    @Query("select p from Property p join p.categories c where c = :category")
    List<Property> findAllByCategory(@Param("category") Category category);
}
