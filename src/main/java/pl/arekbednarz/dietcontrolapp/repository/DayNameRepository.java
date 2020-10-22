package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.dietcontrolapp.entity.DayName;

@Repository
public interface DayNameRepository extends JpaRepository<DayName, Long> {
}

