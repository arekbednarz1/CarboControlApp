package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arekbednarz.dietcontrolapp.entity.Meals;

import pl.arekbednarz.dietcontrolapp.repository.MealsRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MealsServiceDb implements MealService {

    @Autowired
    MealsRepository mealsRepository;
    @Override
   public List<Meals> listAll(String keyword){

           return mealsRepository.findMealsByName(keyword);

   }
    @Override
   public void save (Meals meal){
       mealsRepository.save(meal);
   }

    @Override
   public Meals findById(Long id){
      return mealsRepository.findMealsById(id);
   }
       }




