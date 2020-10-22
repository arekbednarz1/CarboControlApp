package pl.arekbednarz.dietcontrolapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@Table(name = "recipe_plan")
public class RecipePlan implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;


    @ManyToOne
    @JoinColumn(name = "day_name_id")
    private DayName dayName;

    @Column(name = "order_no")
    private Integer order;

    @Column(name = "meal_name")
    private String mealName;

    public Long getId() {
        return id;
    }

}
