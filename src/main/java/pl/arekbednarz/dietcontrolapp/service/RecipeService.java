package pl.arekbednarz.dietcontrolapp.service;

import pl.arekbednarz.dietcontrolapp.entity.Recip;
import pl.arekbednarz.dietcontrolapp.web.dto.RecipeDTO;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    int getUserRecipesCount(Long userId);

    List<Recip> findAllRecipesByUserId(Long userId);

    void save(Recip recip);

    RecipeDTO getOneIfUserCan(Long recipeId, Long userId);

    List<Recip> findAll();

    RecipeDTO getOne(Long id);

    RecipeDTO createRecipeDTO(Recip recip);

    Optional<Recip> find(Long id);

    void update(Recip recip);

    void delete(Long id);

    List<Recip> listAll(String keyword);


    List<Recip> getRecipsByMealHistory_Type(String type);
}

