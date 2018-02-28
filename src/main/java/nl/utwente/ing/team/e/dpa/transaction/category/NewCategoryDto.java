package nl.utwente.ing.team.e.dpa.transaction.category;

import javax.validation.constraints.NotNull;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public class NewCategoryDto {

    @NotNull
    private String name;

    public NewCategoryDto() {
    }

    public NewCategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
