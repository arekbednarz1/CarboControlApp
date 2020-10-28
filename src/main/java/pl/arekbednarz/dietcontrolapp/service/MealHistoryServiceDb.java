package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.Recip;
import pl.arekbednarz.dietcontrolapp.repository.MealHistoryRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MealHistoryServiceDb implements MealHistoryService{

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
    public Optional<MealHistory> findByRecipe(Recip recip){
        return mealHistoryRepository.findByRecip(Optional.ofNullable(recip));
    }

    public List<MealHistory> findByUserId(Long id){
        return mealHistoryRepository.findByUserId(id);
    }


}




