package nl.utwente.ing.team.e.dpa.transaction;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public class NewTransactionDto {

    @NotNull
    private Date date;

    @NotNull
    private int amount;

    @NotNull
    private String externalIban;

    @NotNull
    private TransactionType type;

    @NotNull
    private int category;

    public NewTransactionDto() {
    }

    public NewTransactionDto(Date date, int amount, String externalIban, TransactionType type, int category) {
        this.date = date;
        this.amount = amount;
        this.externalIban = externalIban;
        this.type = type;
        this.category = category;
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

    public int getCategory() {
        return category;
    }
}
