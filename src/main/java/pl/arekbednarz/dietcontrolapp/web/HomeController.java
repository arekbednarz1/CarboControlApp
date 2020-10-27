package pl.arekbednarz.dietcontrolapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arekbednarz.dietcontrolapp.entity.MealHistory;
import pl.arekbednarz.dietcontrolapp.entity.User;
import pl.arekbednarz.dietcontrolapp.service.RecipeService;
import pl.arekbednarz.dietcontrolapp.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;



    @GetMapping("/")
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

        return "searchAndAdd/profile";
    }

    @GetMapping("/profile/meals")
    public String profileMeals(Model model){
        model.addAttribute("mealsConsumedToday", userService.mealsConsumedToday());
//        MealHistory mealHistory = new MealHistory();
//        model.addAttribute("mealHistory",mealHistory);
//        model.addAttribute("currentDailyProgressPercentage", analyticsService.percentageToGoal(dailyProgressToGoal, goal));



        model.addAttribute("welcomeMessage", userService.getFirstNameAndTimeOfDay());

        return "searchAndAdd/profileDet";
    }

    @GetMapping("/user_edit")
    public String showUser (Principal principal,Model model){
        User user = userService.findUserByEmail(principal.getName());
        model.addAttribute("user",user);
        return "userEdit";
    }

    @PostMapping("/user_edit")
    public String editUser (@ModelAttribute @Valid User user, BindingResult result){
        User user1 = userService.findUserByEmail(user.getEmail());
        if (result.hasErrors()) {
            return "userEdit";
        }

        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPassword(user.getPassword());
        userService.save(user1);
        return "dashboard/main";

    }

}
