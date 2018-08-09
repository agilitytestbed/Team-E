package nl.utwente.ing.team.e.dpa.transaction.category.rule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.utwente.ing.team.e.dpa.transaction.TransactionType;

import javax.validation.constraints.NotNull;

/**
 * @author Martijn Noorlander
 */
public class NewCategoryRule {

    private String description;

    @NotNull
    private String iBAN;

    @NotNull
    private TransactionType type;

    @JsonProperty(value = "category_id")
    private Long categoryId;

    private boolean applyOnHistory;

    public NewCategoryRule() {
    }

    public NewCategoryRule(String description, String iBAN, TransactionType type, Long categoryId, boolean applyOnHistory) {
        this.description = description;
        this.iBAN = iBAN;
        this.type = type;
        this.categoryId = categoryId;
        this.applyOnHistory = applyOnHistory;
    }

    public String getDescription() {
        return description;
    }

    public String getiBAN() {
        return iBAN;
    }

    public TransactionType getType() {
        return type;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public boolean isApplyOnHistory() {
        return applyOnHistory;
    }
}
