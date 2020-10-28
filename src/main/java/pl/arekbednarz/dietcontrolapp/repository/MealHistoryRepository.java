package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.Recip;

import java.util.List;
import java.util.Optional;

public interface MealHistoryRepository extends JpaRepository<MealHistory,Long> {



    Optional<MealHistory> findByRecip(Optional<Recip> recipe);



   List<MealHistory> findByUserId(Long id);


}
