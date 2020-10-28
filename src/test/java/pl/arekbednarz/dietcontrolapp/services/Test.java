package pl.arekbednarz.dietcontrolapp.services;

import java.util.List;

import com.fatsecret.platform.model.*;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;

public class Test {

    public static void main(String[] args) {
        String key = "a12ed01c1cbe4c84a3a9e0eece610d0a";
        String secret = "f15ff298dc3e4030bb5aa55c70cce613";

        FatsecretService service = new FatsecretService(key, secret);
        service.getRecipe(315L);
        service.searchRecipes("Marinated Herb Chicken");

        Response<CompactRecipe> response = service.searchRecipes("milk");

        System.out.println("Total Results: " + response.getTotalResults());
        System.out.println("Max Results: " + response.getMaxResults());
        System.out.println("Page Number: " + response.getPageNumber());

        List<CompactRecipe> list = response.getResults();

        int i = 1;
        for(CompactRecipe recipe : list) {
            System.out.println(recipe.getName());
            System.out.println(recipe.getId());


            Recipe recipe2 = service.getRecipe(recipe.getId());
            System.out.println(recipe2);
            System.out.println("==================================================================================================================================");
            System.out.println(recipe2.getTypes());
            System.out.println("==================================================================================================================================");


            System.out.println(i + ": " + recipe.getId() + " - " + recipe.getName() + ", Description: " + recipe.getDescription());
            i++;
        }
        System.out.println("==================================================================================================================================");
        Recipe recipe = service.getRecipe(84411L);
        System.out.println(recipe.getId() + " - " + recipe.getName() + ", Description: " + recipe.getDescription());
        System.out.println("Prep Time: " + recipe.getPreparationTime() + ", Cook Time: " + recipe.getCookingTime());

        System.out.println("==>> Directions");

        for(Direction direction: recipe.getDirections()) {
            System.out.println(direction.getNumber() + " - " + direction.getDescription());
        }

        System.out.println("==>> Ingredients");

        for(Ingredient ingredient: recipe.getIngredients()) {
            System.out.println(ingredient.getName() + " - " + ingredient.getNumberOfUnits() + " " + ingredient.getMeasurementDescription());
        }

        Food food = service.getFood(60810L);
        System.out.println("==>> Food");
        System.out.println("Food: " + food.getName());

        Response<CompactFood> res = service.searchFoods("zupa", 1);
        System.out.println("==>> Response");
        System.out.println("Total: " + res.getTotalResults());
        System.out.println("Max: " + res.getMaxResults());
        System.out.println("Size: " + res.getResults().size());
    }
}