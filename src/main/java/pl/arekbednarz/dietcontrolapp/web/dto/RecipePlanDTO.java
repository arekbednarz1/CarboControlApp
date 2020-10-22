package pl.arekbednarz.dietcontrolapp.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class RecipePlanDTO
{
    private String dayName;

    private String mealName;

    private String recipeName;

    private Long recipeId;

    public RecipePlanDTO(String dayName, String mealName, String recipeName, Long recipeId)
    {
        this.dayName = dayName;
        this.mealName = mealName;
        this.recipeName = recipeName;
        this.recipeId = recipeId;
    }

    public String getDayName()
    {
        return dayName;
    }

    public void setDayName(String dayName)
    {
        this.dayName = dayName;
    }

    public String getMealName()
    {
        return mealName;
    }

    public void setMealName(String mealName)
    {
        this.mealName = mealName;
    }

    public String getRecipeName()
    {
        return recipeName;
    }

    public void setRecipeName(String recipeName)
    {
        this.recipeName = recipeName;
    }

    public Long getRecipeId()
    {
        return recipeId;
    }

    public void setRecipeId(Long recipeId)
    {
        this.recipeId = recipeId;
    }

    @Override
    public String toString()
    {
        return "RecipePlanDTO{" +
                "dayName='" + dayName + '\'' +
                ", mealName='" + mealName + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", recipeId='" + recipeId + '\'' +
                '}';
    }


}