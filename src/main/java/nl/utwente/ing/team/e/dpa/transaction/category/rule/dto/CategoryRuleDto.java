package nl.utwente.ing.team.e.dpa.transaction.category.rule.dto;

import nl.utwente.ing.team.e.dpa.transaction.category.rule.CategoryRule;

/**
 * @author Martijn Noorlander
 */
public class CategoryRuleDto {

    private Long id;

    private String description;

    private String iban;

    private Long category_id;

    private boolean applyOnHistory;

    public CategoryRuleDto() {
    }

    public CategoryRuleDto(CategoryRule categoryRule) {
        this.id = categoryRule.getId();
        this.description = categoryRule.getDescription();
        this.iban = categoryRule.getIban();
        this.category_id = categoryRule.getCategory().getId();
        this.applyOnHistory = categoryRule.isApplyOnHistory();
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
}
