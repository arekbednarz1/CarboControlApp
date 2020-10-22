package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arekbednarz.dietcontrolapp.entity.Plan;
import pl.arekbednarz.dietcontrolapp.repository.PlanRepository;
import pl.arekbednarz.dietcontrolapp.web.dto.RecipePlanDTO;

import java.util.*;

@Service
@Transactional
public class PlanService
{
    @Autowired
    PlanRepository planRepository;

    public Optional<Plan> findOne(Long id)
    {
        return planRepository.findById(id);
    }

    public int getUserPlansCount(Long userId)
    {
        return planRepository.getUserPlansCount(userId);
    }

    public String getLastPlanName(Long userId)
    {
        return planRepository.getLastPlanName(userId);
    }

    /**
     * @param userId
     * @return last user plan as map key->value: dayName -> List{mealName, recipeName, recipeDescription}
     */
    public Map<String, List<RecipePlanDTO>> getLastPlanMap(Long userId)
    {
        return getPlanMap(getUserLastPlan(userId));
    }

    public Map<String, List<RecipePlanDTO>> getSpecifiedPlanMap(Long userId, Long planId)
    {
        return getPlanMap(getUserPlan(planId, userId));
    }

    public List<Plan> findPlansByUserId(Long userId)
    {
        return planRepository.findAllByUserId(userId);
    }

    public void save(Plan plan)
    {
        planRepository.save(plan);
    }

    private Map<String, List<RecipePlanDTO>> getPlanMap(List<RecipePlanDTO> recipePlanDTOList)
    {
        Map<String, List<RecipePlanDTO>> map = new LinkedHashMap<>(); // LinkedHashMap - like HashMap but save order of items

        String lastDayName = "";
        List<RecipePlanDTO> oneDayDTOList = null;

        for (RecipePlanDTO dto : recipePlanDTOList)
        {
            if (lastDayName.equals(dto.getDayName())) // same day
            {
                oneDayDTOList.add(dto);
            }
            else // new day
            {
                if (!lastDayName.equals("")) map.put(lastDayName, oneDayDTOList);
                oneDayDTOList = new ArrayList<>();
                oneDayDTOList.add(dto);
            }
            lastDayName = dto.getDayName();
        }
        map.put(lastDayName, oneDayDTOList); // put last iteration

        return map;
    }

    private List<RecipePlanDTO> getUserLastPlan(Long userId)
    {
        return planRepository.findUserLastPlan(userId);
    }

    private List<RecipePlanDTO> getUserPlan(Long planId, Long userId)
    {
        return planRepository.findUserPlan(planId, userId);
    }

    public Optional<Plan> find(Long id)
    {
        return planRepository.findById(id);
    }

    public void update(Plan plan)
    {
        planRepository.save(plan);
    }

    public void delete(Long id)
    {
        planRepository.deleteById(id);
    }
}