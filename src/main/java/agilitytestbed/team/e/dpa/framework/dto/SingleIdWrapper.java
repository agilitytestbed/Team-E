package agilitytestbed.team.e.dpa.framework.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public class SingleIdWrapper {

    @NotEmpty
    public Long id;

    public SingleIdWrapper() {
    }

    public SingleIdWrapper(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
