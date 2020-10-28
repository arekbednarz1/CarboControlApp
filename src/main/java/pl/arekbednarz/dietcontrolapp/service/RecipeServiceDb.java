package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arekbednarz.dietcontrolapp.entity.Recip;
import pl.arekbednarz.dietcontrolapp.repository.RecipeRepository;
import pl.arekbednarz.dietcontrolapp.web.dto.RecipeDTO;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeServiceDb implements RecipeService{
    @Autowired
    RecipeRepository recipeRepository;

    public int getUserRecipesCount(Long userId) {
        return recipeRepository.getUserRecipesCount(userId);
    }

    public List<Recip> findAllRecipesByUserId(Long userId) {
        return recipeRepository.getRecipesByUserId(userId);
    }

    public void save(Recip recip) {
        recipeRepository.save(recip);
    }

    public RecipeDTO getOneIfUserCan(Long recipeId, Long userId) {
        Recip recip = recipeRepository.getOneByIdAndUser_Id(recipeId, userId);
        return createRecipeDTO(recip);
    }

    public List<Recip> findAll()
    {
        return recipeRepository.findAllByOrderByIdDesc();
    }

    public RecipeDTO getOne(Long id) {
        Recip recip = recipeRepository.getOne(id);
        return createRecipeDTO(recip);
    }


    public RecipeDTO createRecipeDTO(Recip recip) {
        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setCreated(recip.getCreated());
        recipeDTO.setId(recip.getId());
        recipeDTO.setName(recip.getName());
        recipeDTO.setUpdated(recip.getUpdated());

        return recipeDTO;
    }

    public Optional<Recip> find(Long id) {
        return recipeRepository.findById(id);
    }

    public void update(Recip recip) {
        recipeRepository.save(recip);
    }

    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }


    public List<Recip> listAll(String keyword) {
        if (keyword != null) {
            return recipeRepository.searchRecipes(keyword);
        }
        return recipeRepository.findAll();
    }

    public List<Recip> getRecipsByMealHistory_Type(String type) {
        return this.recipeRepository.getRecipsByMealHistory_Type(type);
    }
}