package pl.arekbednarz.dietcontrolapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@ToString
@Getter
@Setter
@Entity
@Table(name ="meal_history")
public class MealHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer heavy;

    private LocalDate created;

    private String Type;

    @ManyToOne
    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    private Recip recip;

}
