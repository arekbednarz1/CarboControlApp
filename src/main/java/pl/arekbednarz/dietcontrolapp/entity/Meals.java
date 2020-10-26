package pl.arekbednarz.dietcontrolapp.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "meals")
public class Meals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer heavy;

    private Double carbs;
}
