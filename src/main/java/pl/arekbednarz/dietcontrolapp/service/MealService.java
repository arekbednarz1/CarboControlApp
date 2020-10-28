package pl.arekbednarz.dietcontrolapp.service;

import pl.arekbednarz.dietcontrolapp.entity.Meals;

import java.util.List;

public interface MealService {

    List<Meals> listAll(String keyword);
    void save (Meals meal);
    Meals findById(Long id);
}
