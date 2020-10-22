package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.dietcontrolapp.entity.RecipePlan;

@Repository
public interface RecipePlanRepository extends JpaRepository<RecipePlan, Long>
{
    public RecipePlan findByRecipeId(Long id);
}
