package pl.arekbednarz.dietcontrolapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer heavy;

    private Integer carbs;

    private LocalDateTime created;

    private LocalDateTime updated;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "recipe")
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

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();  // this field will be autofilled
    }




    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", user=" + user +
                ", recipePlans=" + recipePlans +
                '}';
    }
}