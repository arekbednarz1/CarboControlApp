package pl.arekbednarz.dietcontrolapp.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RecipeDTO
{
    private Long id;

    private String name;

    private String heavy;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Integer preparationTime;

    private String preparation;


    @Override
    public String toString()
    {
        return "RecipeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", preparationTime=" + preparationTime +
                ", preparation='" + preparation + '\'' +
                '}';
    }
}