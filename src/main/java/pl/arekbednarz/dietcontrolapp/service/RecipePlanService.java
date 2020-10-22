package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arekbednarz.dietcontrolapp.entity.RecipePlan;
import pl.arekbednarz.dietcontrolapp.repository.RecipePlanRepository;

@Service
@Transactional
public class RecipePlanService
{
    @Autowired
    private RecipePlanRepository recipePlanRepository;

    public void save(RecipePlan recipePlan)
    {
        recipePlanRepository.save(recipePlan);
    }

    public RecipePlan getRecipePlanByRecipeId(Long id) {
        return recipePlanRepository.findByRecipeId(id);
    }
}

