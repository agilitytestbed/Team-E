package nl.utwente.ing.team.e.dpa.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.utwente.ing.team.e.dpa.transaction.TransactionType;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * DTO For new transactions
 * @author Martijn Noorlander
 * @since 4-2-2018.
 */
public class NewTransactionDto {

    //@NotNull
    private Date date;

    @NotNull
    private double amount;

    @NotNull
    @JsonProperty(value = "externalIBAN")
    private String externalIBAN;

    @NotNull
    private TransactionType type;

    private String description;

    private Long category;

    public NewTransactionDto() {
    }

    public NewTransactionDto(Date date, double amount, String externalIban, TransactionType type, Long category, String description) {
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.externalIBAN = externalIban;
        this.type = type;
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getExternalIban() {
        return externalIBAN;
    }

    public TransactionType getType() {
        return type;
    }

    public Long getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
