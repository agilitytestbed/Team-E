package nl.utwente.ing.team.e.dpa.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
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
}


