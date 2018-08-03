package nl.utwente.ing.team.e.dpa.transaction.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper for a single Long Id
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public class SingleCategoryIdWrapper {

    @JsonProperty(value="category_id")
    public Long id;

    public SingleCategoryIdWrapper() {
    }

    public SingleCategoryIdWrapper(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
