package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.dietcontrolapp.entity.Recipe;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query(value = "SELECT count(*) FROM recipe r WHERE r.user_id = ?1", nativeQuery = true)
    int getUserRecipesCount(Long userId);

    @Query("SELECT r from Recipe r where r.user.id =?1")
    List<Recipe> getRecipesByUserId(Long userId);

    Recipe getOneByIdAndUser_Id(Long recipeId, Long userId);

    List<Recipe> findAllByOrderByIdDesc();

    @Query("SELECT r FROM Recipe r WHERE r.name LIKE %?1%")
     List<Recipe> searchRecipes (String keyword);

    Optional<Recipe> findById(Long id);
}

