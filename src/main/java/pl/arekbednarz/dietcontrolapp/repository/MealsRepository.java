package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.arekbednarz.dietcontrolapp.entity.Meals;

import java.util.List;

public interface MealsRepository extends JpaRepository<Meals,Long> {


    @Query(value = "select m FROM Meals m where m.name like %:keyword%")
    List<Meals> findMealsByName (String keyword);

    Meals findMealsById(Long id);





}
