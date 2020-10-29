package pl.arekbednarz.dietcontrolapp.service;

import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.Recip;

import java.util.List;
import java.util.Optional;

public interface MealHistoryService {
   void save (MealHistory meal);
   void delete(MealHistory mealHistory);
   Optional<MealHistory> findById(Long id);
   Optional<MealHistory> findByRecipe(Recip recip);
   List<MealHistory> findByUserId(Long id);


}
