package ru.breadwinner.service.property.value;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.breadwinner.service.property.Property;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyAvailableValueRepository extends JpaRepository<PropertyAvailableValue, Integer> {

    List<PropertyAvailableValue> findAllByProperty(Property property);

    Optional<PropertyAvailableValue> findByPropertyAndId(Property property, int id);
}