package pl.arekbednarz.dietcontrolapp.web;



import com.fatsecret.platform.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.arekbednarz.dietcontrolapp.entity.*;
import pl.arekbednarz.dietcontrolapp.service.MealHistoryServiceDb;
import pl.arekbednarz.dietcontrolapp.service.MealsServiceDb;
import pl.arekbednarz.dietcontrolapp.service.RecipeServiceDb;
import pl.arekbednarz.dietcontrolapp.service.UserServiceDb;


import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MealsController {

    @Autowired
    private MealsServiceDb mealsServiceDb;

    @Autowired
    private UserServiceDb userServiceDb;

    @Autowired
    private RecipeServiceDb recipeServiceDb;

    @Autowired
    private MealHistoryServiceDb mealHistoryServiceDb;



    @GetMapping("/search")
        public String show(){
        return "searchAndAdd/search";
        }




    @GetMapping("/searchM")
    public String search(Model model, @Param("keyword") String keyword)  {
        MealHistory mealHistory = new MealHistory();
        Recipe recipe =new Recipe();
        List<Meals> list = mealsServiceDb.listAll(keyword);
        if (list.size()!=0){
            model.addAttribute("mealsList", list);

            model.addAttribute("dish",mealHistory);
            model.addAttribute("recipe",recipe);
            return "searchAndAdd/listOfmeals";


        }else {

            return "redirect:/addMeal";
        }

    }


        @GetMapping("/addMeal")
        public String addMealForm(Model model, Principal principal){
        User user = userServiceDb.findUserByEmail(principal.getName());
        Meals meal = new Meals();
        Recip recip =new Recip();
        MealHistory mealHistory = new MealHistory();
        model.addAttribute("meal", meal);
        model.addAttribute("user", user);
        model.addAttribute("dish",mealHistory);
        model.addAttribute("recipe", recip);


        return "searchAndAdd/addMeal";
        }


        @PostMapping("/addMeal")
        public String addMeal(@ModelAttribute Meals meal,@ModelAttribute MealHistory mealHistory, Principal principal,BindingResult result){
        if (result.hasErrors()){
            return "searchAndAdd/addMeal";
        }

        double carbs = meal.getCarbs();
        double heavy =meal.getHeavy();
        double results = carbs/heavy*100;
            System.out.println(results);

            User user = userServiceDb.findUserByEmail(principal.getName());
        Recip recip = new Recip();
        Meals meals = new Meals();
        meals.setName(meal.getName());
        meals.setHeavy(100);
        meals.setCarbs((double)(Math.round(results*100))/100);
        recip.setName(meal.getName());
        recip.setCarbs(meal.getCarbs());
        recip.setHeavy(meal.getHeavy());
        recip.setUser(user);


        MealHistory mealHistory1 = new MealHistory();
        mealHistory1.setUser(user);
        mealHistory1.setRecip(recip);
        mealHistory1.setHeavy(meal.getHeavy());
        mealHistory1.setCreated(LocalDate.now());
        mealHistory1.setType(mealHistory.getType());

        mealHistoryServiceDb.save(mealHistory1);

        recip.setMealHistory(mealHistory1);
        recipeServiceDb.save(recip);
        mealsServiceDb.save(meals);

        return "redirect:/profile";

        }



    @PostMapping("/addToHistory")
    public String addRecipe(@ModelAttribute MealHistory mealHistory, Principal principal) {
        System.out.println(mealHistory.getType());
        System.out.println(mealHistory.getHeavy());


        double carbs = mealHistory.getRecip().getCarbs()/100;
        Integer weight =mealHistory.getHeavy();
        double results = carbs*weight;

        System.out.println(results);

        User user = userServiceDb.findUserByEmail(principal.getName());
        MealHistory mealHistory1 = new MealHistory();
        Recip recip = new Recip();

        mealHistory1.setType(mealHistory.getType());
        mealHistory1.setCreated(LocalDate.now());
        mealHistory1.setHeavy(mealHistory.getHeavy());
        mealHistory1.setUser(user);


        recip.setCarbs((double)(Math.round(results*100))/100);
        recip.setCreated(LocalDate.now());
        recip.setHeavy(weight);
        recip.setName(mealHistory.getRecip().getName());
        recip.setUser(user);
        mealHistory1.setRecip(recip);

        mealHistory1.setType(mealHistory.getType());
        mealHistory1.setCreated(LocalDate.now());
        mealHistory1.setHeavy(mealHistory.getHeavy());
        mealHistory1.setUser(user);
        mealHistory1.setRecip(recip);

        mealHistoryServiceDb.save(mealHistory1);
        recip.setMealHistory(mealHistory1);
        recipeServiceDb.save(recip);


        return "redirect:/profile";

    }





    @GetMapping("/dailyDetail")
    public String showDaily(@ModelAttribute MealHistory mealHistory, Model model, Principal principal) {
        User user = userServiceDb.findUserByEmail(principal.getName());

//        List<MealHistory> mealHistories = mealHistoryServiceDb.findByUserId(user.getId());
        List<MealHistory> mealHistories1 =mealHistoryServiceDb.findByUserId(user.getId());
        List<MealHistory> mealHistories =mealHistoryServiceDb.findByUserId(user.getId()).stream()
                .filter(s->s.getType().equals(mealHistory.getType()))
                .collect(Collectors.toList());
       List<Recip> recipList = new ArrayList<>();
       Double count = 0.0d;
        for (MealHistory m : mealHistories){
           recipList.add(m.getRecip());
           count+=m.getRecip().getCarbs();
        }

        Double wym = (double)((Math.round(count*100))/100)/10;

        model.addAttribute("pos", recipList);
        model.addAttribute("carb", count);
        model.addAttribute("wym",wym);
        return "searchAndAdd/index2";
    }

//    testowe
    @RequestMapping("/Madd")
    public void addRecipe ()
    {
        Meals meals =new Meals();
        meals.setName("chleb");
//        meals.setCarbs(2);
        meals.setHeavy(100);

        mealsServiceDb.save(meals);

    }
    }




