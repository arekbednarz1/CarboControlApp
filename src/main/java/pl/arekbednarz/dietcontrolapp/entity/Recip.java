package pl.arekbednarz.dietcontrolapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class Recip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer heavy;

    private Double carbs;

    private LocalDate created;

    private LocalDate updated;

    @ManyToOne
    private User user;

    @OneToOne
    private MealHistory mealHistory;


    @PrePersist
    public void prePersist() {
        created = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDate.now();
    }




    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", user=" + user +

                '}';
    }
}