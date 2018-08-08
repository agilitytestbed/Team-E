package nl.utwente.ing.team.e.dpa.transaction.category.rule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.utwente.ing.team.e.dpa.security.authentication.Authenticated;
import nl.utwente.ing.team.e.dpa.transaction.TransactionType;
import nl.utwente.ing.team.e.dpa.transaction.category.Category;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.dto.NewCategoryRule;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Martijn Noorlander
 */
@Entity
public class CategoryRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String iban;

    private Timestamp timeStamp;

    private TransactionType transactionType;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Category category;

    @ManyToOne
    @JsonIgnore
    private Authenticated authenticated;

    private boolean applyOnHistory;

    public CategoryRule() {
        this.timeStamp = new Timestamp(System.currentTimeMillis());
    }

    public CategoryRule(NewCategoryRule newRule) {
        this();
        this.description = newRule.getDescription();
        this.iban = newRule.getiBAN();
        this.applyOnHistory = newRule.isApplyOnHistory();
        this.transactionType = newRule.getType();
    }

    public CategoryRule(String description, String iban, Category category, Authenticated authenticated, boolean applyOnHistory, TransactionType type) {
        this();
        this.transactionType = type;
        this.description = description;
        this.iban = iban;
        this.category = category;
        this.authenticated = authenticated;
        this.applyOnHistory = applyOnHistory;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Authenticated getAuthenticated() {
        return authenticated;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setAuthenticated(Authenticated authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isApplyOnHistory() {
        return applyOnHistory;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setApplyOnHistory(boolean applyOnHistory) {
        this.applyOnHistory = applyOnHistory;
    }
}
