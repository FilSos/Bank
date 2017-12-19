package pl.sda.poznan.bank.backend.web.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PaymentAndPayoffVM {

    @NotNull
    private String sourceAccountNumber;
    @NotNull
    private double amount;
    private String notes;

    public PaymentAndPayoffVM(String sourceAccountNumber, double amount, String notes) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.amount = amount;
        this.notes = notes;
    }
}
