package pl.arekbednarz.dietcontrolapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.User;
import pl.arekbednarz.dietcontrolapp.service.RecipeService;
import pl.arekbednarz.dietcontrolapp.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;



    @GetMapping("/") // also dashboard controller
    public String LandingPageController(Principal principal, Model model) {

        model.addAttribute("logged_user", principal);

        if (principal != null)
        {
            User user = userService.findUserByEmail(principal.getName());
            model.addAttribute("user", user);
            model.addAttribute("recipes_count", recipeService.getUserRecipesCount(user.getId()));

        }

        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        model.addAttribute("foodConsumedToday", userService.foodConsumedToday());
        MealHistory mealHistory = new MealHistory();
        model.addAttribute("mealHistory",mealHistory);

//        model.addAttribute("currentDailyProgressPercentage", analyticsService.percentageToGoal(dailyProgressToGoal, goal));

        model.addAttribute("welcomeMessage", userService.getFirstNameAndTimeOfDay());

        return "search/profile";
    }

    @GetMapping("/profile/meals")
    public String profileMeals(Model model){
        model.addAttribute("mealsConsumedToday", userService.mealsConsumedToday());
//        MealHistory mealHistory = new MealHistory();
//        model.addAttribute("mealHistory",mealHistory);
//        model.addAttribute("currentDailyProgressPercentage", analyticsService.percentageToGoal(dailyProgressToGoal, goal));



        model.addAttribute("welcomeMessage", userService.getFirstNameAndTimeOfDay());

        return "search/profileDet";
    }
}
