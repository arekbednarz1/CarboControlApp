package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arekbednarz.dietcontrolapp.entity.Recipe;
import pl.arekbednarz.dietcontrolapp.repository.RecipeRepository;
import pl.arekbednarz.dietcontrolapp.web.dto.RecipeDTO;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public int getUserRecipesCount(Long userId) {
        return recipeRepository.getUserRecipesCount(userId);
    }

    public List<Recipe> findAllRecipesByUserId(Long userId) {
        return recipeRepository.getRecipesByUserId(userId);
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public RecipeDTO getOneIfUserCan(Long recipeId, Long userId) {
        Recipe recipe = recipeRepository.getOneByIdAndUser_Id(recipeId, userId);
        return createRecipeDTO(recipe);
    }

    public List<Recipe> findAll()
    {
        return recipeRepository.findAllByOrderByIdDesc();
    }

    public RecipeDTO getOne(Long id) {
        Recipe recipe = recipeRepository.getOne(id);
        return createRecipeDTO(recipe);
    }


    private RecipeDTO createRecipeDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setCreated(recipe.getCreated());
        recipeDTO.setId(recipe.getId());
        recipeDTO.setName(recipe.getName());
        recipeDTO.setUpdated(recipe.getUpdated());

        return recipeDTO;
    }

    public Optional<Recipe> find(Long id) {
        return recipeRepository.findById(id);
    }

    public void update(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }


    public List<Recipe> listAll(String keyword) {
        if (keyword != null) {
            return recipeRepository.searchRecipes(keyword);
        }
        return recipeRepository.findAll();
    }
}