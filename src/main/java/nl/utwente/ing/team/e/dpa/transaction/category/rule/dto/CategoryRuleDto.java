package nl.utwente.ing.team.e.dpa.transaction.category.rule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.utwente.ing.team.e.dpa.transaction.TransactionType;
import nl.utwente.ing.team.e.dpa.transaction.category.rule.CategoryRule;

/**
 * @author Martijn Noorlander
 */
public class CategoryRuleDto {

    private Long id;

    private String description;

    @JsonProperty(value = "iBAN")
    private String iban;

    private Long category_id;

    private boolean applyOnHistory;

    private TransactionType type;

    public CategoryRuleDto() {
    }

    public CategoryRuleDto(CategoryRule categoryRule) {
        this.id = categoryRule.getId();
        this.description = categoryRule.getDescription();
        this.iban = categoryRule.getIban();
        this.category_id = categoryRule.getCategory().getId();
        this.applyOnHistory = categoryRule.isApplyOnHistory();
        this.type = categoryRule.getTransactionType();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getIban() {
        return iban;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public boolean isApplyOnHistory() {
        return applyOnHistory;
    }

    public TransactionType getType() {
        return type;
    }
}
