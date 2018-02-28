package nl.utwente.ing.team.e.dpa.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.utwente.ing.team.e.dpa.security.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018
 */
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Authenticated authenticated;

    private Date date;

    private int amount;

    private String externalIban;

    private TransactionType type;

    @ManyToOne
    private Category category;

    public Transaction() {
    }

    public Transaction(Authenticated authenticated, Date date, int amount, String externalIban, TransactionType type, Category category) {
        this.authenticated = authenticated;
        this.date = date;
        this.amount = amount;
        this.externalIban = externalIban;
        this.type = type;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public Authenticated getAuthenticated() {
        return authenticated;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public String getExternalIban() {
        return externalIban;
    }

    public TransactionType getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }
}
