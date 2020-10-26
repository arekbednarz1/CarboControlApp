package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface MealHistoryRepository extends JpaRepository<MealHistory,Long> {



    Optional<MealHistory> findByRecipe(Optional<Recipe> recipe);



   List<MealHistory> findByUserId(Long id);


}
