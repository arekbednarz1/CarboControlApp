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
import pl.arekbednarz.dietcontrolapp.service.RecipeServiceDb;
import pl.arekbednarz.dietcontrolapp.service.UserServiceDb;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    UserServiceDb userServiceDb;

    @Autowired
    RecipeServiceDb recipeServiceDb;


    @GetMapping("/")
    public String LandingPageController(Principal principal, Model model) {

        model.addAttribute("logged_user", principal);

        if (principal != null) {
            User user = userServiceDb.findUserByEmail(principal.getName());
            model.addAttribute("user", user);


        }

        return "index";
    }



    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("foodConsumedToday", userServiceDb.foodConsumedToday());
        MealHistory mealHistory = new MealHistory();
        model.addAttribute("mealHistory", mealHistory);


        model.addAttribute("welcomeMessage", userServiceDb.getFirstNameAndTimeOfDay());

        return "searchAndAdd/profile";
    }

    @GetMapping("/profile/meals")
    public String profileMeals(Model model, Principal principal) {
        User user = userServiceDb.findUserByEmail(principal.getName());
        MealHistory mealHistory = new MealHistory();
        model.addAttribute("mealsConsumedToday", userServiceDb.mealsConsumedToday());
        model.addAttribute("welcomeMessage", userServiceDb.getFirstNameAndTimeOfDay());
        model.addAttribute("dish",mealHistory);

        return "searchAndAdd/profileDet";
    }

    @GetMapping("/user_edit")
    public String showUser(Principal principal, Model model) {
        User user = userServiceDb.findUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "dashboard/userEdit";
    }

    @PostMapping("/user_edit")
    public String editUser(@ModelAttribute @Valid User user, BindingResult result) {
        User user1 = userServiceDb.findUserByEmail(user.getEmail());
        if (user.getPassword() != null) {
            if (result.hasErrors()) {
                return "dashboard/userEdit";
            }

            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setPassword(user.getPassword());


        } else {
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setPassword(userServiceDb.findUserByEmail(user.getEmail()).getPassword());

        }
        userServiceDb.save(user1);
        return "dashboard/main";
    }
}