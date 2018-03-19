package nl.utwente.ing.team.e.dpa.transaction.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.category.dto.NewCategoryDto;

import javax.persistence.*;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JsonIgnore
    private Authenticated authenticated;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(NewCategoryDto newCategoryDto, Authenticated current) {
        this.name = newCategoryDto.getName();
        this.authenticated = current;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Authenticated getAuthenticated() {
        return authenticated;
    }

    public void setName(String name) {
        this.name = name;
    }
}
