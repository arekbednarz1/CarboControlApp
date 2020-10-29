package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.Recip;
import pl.arekbednarz.dietcontrolapp.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealHistoryRepository extends JpaRepository<MealHistory,Long> {



    Optional<MealHistory> findByRecip(Optional<Recip> recipe);



   List<MealHistory> findByUserId(Long id);



   List<MealHistory>findAllByType(String type);


}
