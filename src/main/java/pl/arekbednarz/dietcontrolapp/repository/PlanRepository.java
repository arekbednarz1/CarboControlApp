package pl.arekbednarz.dietcontrolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.dietcontrolapp.entity.Plan;
import pl.arekbednarz.dietcontrolapp.web.dto.RecipePlanDTO;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>
{
    @Query(value = "SELECT count(*) FROM plan p WHERE p.user_id = ?1", nativeQuery = true)
    int getUserPlansCount(Long userId);

    @Query(nativeQuery = true, name = "LastPlanResult")
    List<RecipePlanDTO> findUserLastPlan(Long userId); // mapped to RecipePlanDTO in Plan entity

    @Query(nativeQuery = true, name = "UserPlanResult")
    List<RecipePlanDTO> findUserPlan(Long planId, Long userId); // mapped to RecipePlanDTO in Plan entity

    @Query(value = "SELECT name FROM plan WHERE id = (SELECT MAX(id) FROM plan WHERE user_id = ?1)", nativeQuery = true)
    String getLastPlanName(Long userId);

    List<Plan> findAllByUserId(Long userId);
}