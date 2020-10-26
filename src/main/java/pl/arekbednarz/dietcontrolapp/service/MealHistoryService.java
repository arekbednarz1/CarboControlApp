package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.Recipe;
import pl.arekbednarz.dietcontrolapp.repository.MealHistoryRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MealHistoryService {

    @Autowired
    MealHistoryRepository mealHistoryRepository;

    public void save (MealHistory meal){

        mealHistoryRepository.save(meal);

    }

    public void delete(MealHistory mealHistory){
        mealHistoryRepository.delete(mealHistory);
    }
    public Optional<MealHistory> findById(Long id){
       return mealHistoryRepository.findById(id);
    }
    public Optional<MealHistory> findByRecipe(Recipe recipe){
        return mealHistoryRepository.findByRecipe(Optional.ofNullable(recipe));
    }

    public List<MealHistory> findByUserId(Long id){
        return mealHistoryRepository.findByUserId(id);
    }


}




