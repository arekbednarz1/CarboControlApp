package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.Recipe;
import pl.arekbednarz.dietcontrolapp.entity.User;
import pl.arekbednarz.dietcontrolapp.repository.RecipeRepository;
import pl.arekbednarz.dietcontrolapp.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private MealHistoryService mealHistoryService;

    private RecipeRepository recipeRepository;

    @Autowired
    public UserService(UserRepository userRepository,MealHistoryService mealHistoryService,
                        BCryptPasswordEncoder bCryptPasswordEncoder,RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.recipeRepository = recipeRepository;
        this.mealHistoryService = mealHistoryService;
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

   public User findUserByPasswordBefore(String password){
        return userRepository.findUserByPasswordBefore(password);
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


   public List<Recipe> foodConsumedToday(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        User currentUser = userRepository.findUserByEmail(((UserDetails)principal).getUsername());
        if (recipeRepository.getRecipesByUserId(currentUser.getId()) == null){
            List<Recipe> list = new ArrayList<>();
            return list;
        }
        List<Recipe> foodList = recipeRepository.getRecipesByUserId(currentUser.getId());
        List<Recipe> listToReturn = foodList.stream()
                .filter(food -> food.getCreated().isBefore(LocalDate.now().plusDays(1)))
                .filter(food -> food.getCreated().isAfter(LocalDate.now().minusDays(1)))
                .collect(Collectors.toList());

        return listToReturn;

    }


    public List<MealHistory> mealsConsumedToday(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        User currentUser = userRepository.findUserByEmail(((UserDetails)principal).getUsername());
        if (recipeRepository.getRecipesByUserId(currentUser.getId()) == null){
            List<MealHistory> list = new ArrayList<>();
            return list;
        }
        List<MealHistory> foodList = mealHistoryService.findByUserId(currentUser.getId());
        List<MealHistory> listToReturn = foodList.stream()
                .filter(food -> food.getCreated().isBefore(LocalDate.now().plusDays(1)))
                .filter(food -> food.getCreated().isAfter(LocalDate.now().minusDays(1)))
                .collect(Collectors.toList());

        return listToReturn;

    }
    public String getFirstNameAndTimeOfDay(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        User currentUser = userRepository.findUserByEmail(((UserDetails)principal).getUsername());
        String firstName = currentUser.getFirstName();
        String returnString = "";

        LocalTime currentTime = LocalTime.now();

        int timeInt = Integer.parseInt(currentTime.toString().split(":")[0]);
        if (timeInt > 0 && timeInt < 12){
            returnString = "Dzień dobry o poranku "+firstName+".";
        }
        else if (timeInt > 12 && timeInt < 17){
            returnString = "Witamy po południu"+firstName+".";
        }
        else if (timeInt > 17 && timeInt < 24){
            returnString = "Dobry wieczór "+firstName+".";
        }

        return returnString;
    }
}
