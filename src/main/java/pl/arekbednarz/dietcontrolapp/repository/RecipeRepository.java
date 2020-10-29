package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.dietcontrolapp.entity.Recip;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recip, Long> {
    @Query(value = "SELECT count(*) FROM recip r WHERE r.user_id = ?1", nativeQuery = true)
    int getUserRecipesCount(Long userId);

    @Query("SELECT r from Recip r where r.user.id =?1")
    List<Recip> getRecipesByUserId(Long userId);

    Recip getOneByIdAndUser_Id(Long recipeId, Long userId);

    List<Recip> findAllByOrderByIdDesc();

    @Query("SELECT r FROM Recip r WHERE r.name LIKE %?1%")
     List<Recip> searchRecipes (String keyword);

    Optional<Recip> findById(Long id);


    @Query("select r FROM Recip r WHERE r.mealHistory.type = ?1")
    List<Recip> getRecipsByMealHistory_Type(String type);
}

