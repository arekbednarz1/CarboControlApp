package pl.arekbednarz.dietcontrolapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "day_name")
public class DayName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max=45)
    private String name;

    @Column(name = "order_no")
    private int order;

    @OneToMany(mappedBy = "dayName")
    private List<RecipePlan> recipePlans;


}