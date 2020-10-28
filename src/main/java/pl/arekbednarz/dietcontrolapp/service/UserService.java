package pl.arekbednarz.dietcontrolapp.service;

import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.Recip;
import pl.arekbednarz.dietcontrolapp.entity.User;

import java.util.List;

public interface UserService {

    User findUserByEmail(String email);

    User findUserById(Long id);

    User findUserByPasswordBefore(String password);

    void save(User user);

    List<Recip> foodConsumedToday();

    List<MealHistory> mealsConsumedToday();

    String getFirstNameAndTimeOfDay();
}
