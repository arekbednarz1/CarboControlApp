package pl.arekbednarz.dietcontrolapp.entity;

import lombok.Getter;
import lombok.Setter;
import pl.arekbednarz.dietcontrolapp.web.dto.RecipePlanDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "plan")
@SqlResultSetMapping(
        name = "LastPlanResult", // resultSet name
        classes = {
                @ConstructorResult(
                        targetClass = RecipePlanDTO.class, // target mapping class
                        columns = {
                                @ColumnResult(name = "day_name"), // column names returned by query in RIGHT order
                                @ColumnResult(name = "meal_name"),
                                @ColumnResult(name = "recipe_name"),
                                @ColumnResult(name = "recipe_id", type = Long.class) // target class (DTO) must have constructor for this columns in RIGHT order
                        }
                )
        }
)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "LastPlanResult", // result set mapping name
                query = "SELECT day_name.name as day_name, meal_name,  recipe.name as recipe_name, recipe.id as recipe_id\n" +
                        "FROM recipe_plan\n" +
                        "       JOIN day_name on day_name.id=day_name_id\n" +
                        "       JOIN recipe on recipe.id=recipe_id WHERE\n" +
                        "    plan_id =  (SELECT MAX(id) from plan WHERE user_id = ?1)\n" +
                        "ORDER by day_name.order_no, recipe_plan.order_no",
                resultClass = RecipePlanDTO.class, // this query will be mapped to RecipePlanDTO class
                resultSetMapping = "LastPlanResult") // result set mapping name
        ,
        @NamedNativeQuery(
                name = "UserPlanResult", // result set mapping name
                query = "SELECT day_name.name as day_name, meal_name,  recipe.name as recipe_name, recipe.id as recipe_id\n" +
                        "FROM recipe_plan\n" +
                        "       JOIN day_name on day_name.id=day_name_id\n" +
                        "       JOIN recipe on recipe.id=recipe_id WHERE\n" +
                        "    plan_id = ?1 AND user_id = ?2\n" +
                        "ORDER by day_name.order_no, recipe_plan.order_no",
                resultClass = RecipePlanDTO.class, // this query will be mapped to RecipePlanDTO class
                resultSetMapping = "LastPlanResult") // result set mapping name
})
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime created;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.REMOVE)
    private List<RecipePlan> recipePlans;

    public List<RecipePlan> getRecipePlans() {
        return recipePlans;
    }

    public void setRecipePlans(List<RecipePlan> recipePlans) {
        this.recipePlans = recipePlans;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now(); // this field will be autofilled
    }


    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", user=" + user +
                '}';
    }
}