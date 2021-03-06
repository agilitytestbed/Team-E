package nl.utwente.ing.team.e.dpa.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.dto.NewTransactionDto;

import javax.persistence.*;
import java.util.Date;

/**
 * Transaction Object
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

    private String description;

    private double amount;

    @JsonProperty(value = "externalIBAN")
    private String externalIban;

    private TransactionType type;

    // Set correct relation
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Category category;

    public Transaction() {
    }

    public Transaction(Authenticated authenticated, Date date, double amount, String externalIban, TransactionType type, String description) {
        this.description = description;
        this.authenticated = authenticated;
        this.date = date;
        this.amount = amount;
        this.externalIban = externalIban;
        this.type = type;
    }


    public Transaction(Authenticated authenticated, Date date, double amount, String externalIban, TransactionType type, String description, Category category) {
        this.description = description;
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

    public double getAmount() {
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public void update(NewTransactionDto newTransactionDto) {
        this.description = newTransactionDto.getDescription();
        this.date = newTransactionDto.getDate();
        this.amount = newTransactionDto.getAmount();
        this.externalIban = newTransactionDto.getExternalIban();
        this.type = newTransactionDto.getType();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", authenticated=" + authenticated +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", externalIban='" + externalIban + '\'' +
                ", type=" + type +
                ", category=" + category +
                '}';
    }
}
