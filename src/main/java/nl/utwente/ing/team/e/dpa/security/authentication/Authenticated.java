package nl.utwente.ing.team.e.dpa.security.authentication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * An authenticated user
 * @author Martijn Noorlander
 */
@Entity
public class Authenticated {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Authenticated() {
    }

    public Authenticated(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authenticated that = (Authenticated) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}


