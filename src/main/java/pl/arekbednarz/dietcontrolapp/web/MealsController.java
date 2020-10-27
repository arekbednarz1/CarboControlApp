package pl.arekbednarz.dietcontrolapp.web;

//dorobić delete

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.arekbednarz.dietcontrolapp.entity.*;
import pl.arekbednarz.dietcontrolapp.service.MealHistoryService;
import pl.arekbednarz.dietcontrolapp.service.MealsService;
import pl.arekbednarz.dietcontrolapp.service.RecipeService;
import pl.arekbednarz.dietcontrolapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class MealsController {

    @Autowired
    private MealsService mealsService;

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private MealHistoryService mealHistoryService;

    @GetMapping("/search")
        public String show(){
        return "searchAndAdd/search";
        }

    @GetMapping("/searchM")
    public String search(Model model, @Param("keyword") String keyword)  {
        MealHistory mealHistory = new MealHistory();
        Recipe recipe =new Recipe();
        List<Meals> list = mealsService.listAll(keyword);
            if (list.size()!=0){
            model.addAttribute("mealsList", list);
            model.addAttribute("meal", mealHistory);
            model.addAttribute("dish",mealHistory);
            model.addAttribute("recipe",recipe);
                return "searchAndAdd/listOfmeals";
        }else {
            return "redirect:/addMeal";
        }

        }

        @GetMapping("/addMeal")
        public String addMealForm(Model model, Principal principal){
        User user = userService.findUserByEmail(principal.getName());
        Meals meal = new Meals();
        Recipe recipe =new Recipe();
        MealHistory mealHistory = new MealHistory();
        model.addAttribute("meal", meal);
        model.addAttribute("user", user);
        model.addAttribute("dish",mealHistory);
        model.addAttribute("recipe",recipe);


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

            User user = userService.findUserByEmail(principal.getName());
        Recipe recipe = new Recipe();
        Meals meals = new Meals();
        meals.setName(meal.getName());
        meals.setHeavy(100);
        meals.setCarbs((double)(Math.round(results*100))/100);
        recipe.setName(meal.getName());
        recipe.setCarbs(meal.getCarbs());
        recipe.setHeavy(meal.getHeavy());
        recipe.setUser(user);


        MealHistory mealHistory1 = new MealHistory();
        mealHistory1.setUser(user);
        mealHistory1.setRecipe(recipe);
        mealHistory1.setHeavy(meal.getHeavy());
        mealHistory1.setCreated(LocalDate.now());
        mealHistory1.setType(mealHistory.getType());

        mealHistoryService.save(mealHistory1);

        recipeService.save(recipe);
        mealsService.save(meals);

        return "redirect:/profile";

        }




//    @GetMapping("/food/edit")
//    public String foodEditForm(@ModelAttribute MealHistory mealHistory,Principal principal){
//        User user = userService.findUserByEmail(principal.getName());
//       Optional<MealHistory> mealHistory1 = mealHistoryService.findByRecipe(mealHistory.getRecipe());
//         return "redirect:/profile";
//    }
//
//    public String editFood (@ModelAttribute MealHistory mealHistory, Principal principal){
//        User user = userService.findUserByEmail(principal.getName());
//        mealHistoryService.
//
//
//        return "redirect:/profile";










//    @GetMapping("/meals/{id}")
//    public String editRecipe(Model model, @PathVariable Long id, Principal principal)
//    {
//        User user = userService.findUserByEmail(principal.getName());
//        Meals meal = mealsService.findById(id);
//        model.addAttribute("user", user);
//        model.addAttribute(meal);
//        return "search/listOfmeals";
//    }

    @PostMapping("addToHistory")
    public String addRecipe(@ModelAttribute MealHistory mealHistory, Principal principal) {
        System.out.println(mealHistory.getType());
        System.out.println(mealHistory.getHeavy());
//        System.out.println(mealHistory.getRecipe().getName());
        System.out.println(mealHistory.getRecipe().getCarbs());

        double carbs = mealHistory.getRecipe().getCarbs()/100;
        Integer weight =mealHistory.getHeavy();
        double results = carbs*weight;

        System.out.println(results);

        User user = userService.findUserByEmail(principal.getName());
        MealHistory mealHistory1 = new MealHistory();
        Recipe recipe = new Recipe();

        recipe.setCarbs((double)(Math.round(results*100))/100);
        recipe.setCreated(LocalDate.now());
        recipe.setHeavy(weight);
        recipe.setName(mealHistory.getRecipe().getName());
        recipe.setMealHistory(mealHistory1);
        recipe.setUser(user);

        mealHistory1.setType(mealHistory.getType());
        mealHistory1.setCreated(LocalDate.now());
        mealHistory1.setHeavy(mealHistory.getHeavy());
        mealHistory1.setUser(user);
        mealHistory1.setRecipe(recipe);

        recipeService.save(recipe);
        mealHistoryService.save(mealHistory1);

        return "redirect:/profile";

    }
//
//        Double carbo = (carbs/100)*heavy;
//        User user = userService.findUserByEmail(principal.getName());
//        Meals meals = mealsService.findById(id);
//        meals = mealsService.findById(id);
//        Recipe recipe = new Recipe();
//        recipe.setName(meals.getName());
//        recipe.setHeavy(heavy);
//        recipe.setCarbs(carbo);
//
//        MealHistory mealHistory1 = new MealHistory();
//        mealHistory1.setUser(user);
//        mealHistory1.setRecipe(recipe);
//        mealHistory1.setHeavy(heavy);
//        mealHistory1.setCreated(LocalDate.now());
////        mealHistory1.setType(mealHistory.getType());
//
//        recipe.setUser(user);
//        recipeService.save(recipe);
//        return "redirect:/profile";
//    }



//        @PostMapping("/edit/{id}")
//        public String editEventPost(@PathVariable Long id, @ModelAttribute @Valid Recipe recipe,
//                Principal principal, BindingResult result)
//        {
//            if(result.hasErrors()){
//                return "/WEB-INF/views/recipe/addRecipe.jsp";
//            }
//            if(recipe.getId()==null){
//                recipe.setId(id);
//            }
//            Optional<Recipe> recipeOld = recipeService.find(id);
//            User user = userService.findUserByEmail(principal.getName());
//            recipe.setCreated(recipeOld.orElseThrow().getCreated());
//            recipe.setUser(user);
//            recipeService.update(recipe);
//            return "redirect:../../recipes";
//        }




//    testowe
    @RequestMapping("/Madd")
    public void addRecipe ()
    {
        Meals meals =new Meals();
        meals.setName("chleb");
//        meals.setCarbs(2);
        meals.setHeavy(100);

        mealsService.save(meals);

    }
    }




