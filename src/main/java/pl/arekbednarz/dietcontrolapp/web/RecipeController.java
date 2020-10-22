package pl.arekbednarz.dietcontrolapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.arekbednarz.dietcontrolapp.entity.*;
import pl.arekbednarz.dietcontrolapp.service.*;
import pl.arekbednarz.dietcontrolapp.web.dto.RecipeDTO;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recipes")
public class RecipeController
{

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipePlanService recipePlanService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlanService planService;

    @Autowired
    private DayNameService dayNameService;

    @GetMapping
    public String recipesList(Model model, Principal principal)
    {
        if (principal != null) // if user logged, show his recipes
        {
            User user = userService.findUserByEmail(principal.getName());
            model.addAttribute("user", user);
            model.addAttribute("recipes", recipeService.findAllRecipesByUserId(user.getId()));
            return "recipe/recipesList";
        }
        else // if not logged, show recipes of all users
        {
            model.addAttribute("recipes", recipeService.findAll());
            return "recipe/allRecipes";
        }
    }

    @GetMapping("/add")
    public String addRecipeForm(Model model, Principal principal)
    {
        User user = userService.findUserByEmail(principal.getName());
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        model.addAttribute("user", user);
        return "recipe/addRecipe";
    }

    @PostMapping("/add")
    public String addRecipe (@ModelAttribute @Valid Recipe recipe, Principal principal, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "recipe/addRecipe";
        }
        User user = userService.findUserByEmail(principal.getName());
        recipe.setUser(user);
        recipeService.save(recipe);
        return "redirect:../recipes";
    }

    @GetMapping("/edit/{id}")
    public String editRecipe(Model model, @PathVariable Long id, Principal principal)
    {
        User user = userService.findUserByEmail(principal.getName());
        Optional<Recipe> recipe = recipeService.find(id);
        model.addAttribute("user", user);
        model.addAttribute(recipe);
        return "recipe/addRecipe";
    }

    @PostMapping("/edit/{id}")
    public String editEventPost(@PathVariable Long id, @ModelAttribute @Valid Recipe recipe,
                                Principal principal, BindingResult result)
    {
        if(result.hasErrors()){
            return "recipe/addRecipe";
        }
        if(recipe.getId()==null){
            recipe.setId(id);
        }
        Optional<Recipe> recipeOld = recipeService.find(id);
        User user = userService.findUserByEmail(principal.getName());
        recipe.setCreated(recipeOld.orElseThrow().getCreated());
        recipe.setUser(user);
        recipeService.update(recipe);
        return "redirect:../../recipes";
    }

    @GetMapping("/plan/add")
    public String addRecipeToPlanForm(Model model, Principal principal)
    {
        User user = userService.findUserByEmail(principal.getName());
        RecipePlan recipePlan = new RecipePlan();
        List<Plan> plans = planService.findPlansByUserId(user.getId());
        List<DayName> days = dayNameService.findAll();
        List<Recipe> recipes = recipeService.findAllRecipesByUserId(user.getId());
        model.addAttribute("recipePlan",recipePlan);
        model.addAttribute("plans", plans);
        model.addAttribute("days", days);
        model.addAttribute("recipes", recipes);
        model.addAttribute("user",user);
        return "recipe/addRecipeToPlan";
    }

    @PostMapping("/plan/add")
    public String addRecipeToPlan (@ModelAttribute @Valid RecipePlan recipePlan, BindingResult result)
    {
        if (result.hasErrors()) {
            return "recipe/addRecipeToPlan";
        }
        recipePlanService.save(recipePlan);
        return "redirect:../plan/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe( @PathVariable Long id)
    {
        RecipePlan recipePlan = recipePlanService.getRecipePlanByRecipeId(id);
        if(recipePlan==null) {
            recipeService.delete(id);
            return "redirect:../../recipes";
        }
        else
        {
            //TODO information that this recipe cannot be deleted
            return "redirect:../../recipes";
        }

    }


    @GetMapping("/{id}")
    public String recipeDetails(@PathVariable Long id, Model model, Principal principal)
    {
        try
        {
            if (principal != null)
            {

                User user = userService.findUserByEmail(principal.getName());
                RecipeDTO recipeDTO = recipeService.getOneIfUserCan(id, user.getId());
                model.addAttribute("recipe", recipeDTO);
                return "recipe/details";
            }
            else
            {
                RecipeDTO recipeDTO = recipeService.getOne(id);
                model.addAttribute("recipe", recipeDTO);
                return "recipe/mainDetails";
            }
        }
        catch (NullPointerException | EntityNotFoundException e)
        {
            return "dashboard/403";
        }
    }
}
