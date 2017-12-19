package pl.sda.poznan.bank.backend.web.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TransferVM {
    @NotNull
    private String title;
    @NotNull
    private String sourceAccountNumber;
    @NotNull
    private String destinationAccountNumber;
    @NotNull
    private double amount;
    private String notes;
    private String address;

    public TransferVM(String title, String sourceAccountNumber, String destinationAccountNumber, double amount, String notes, String address) {
        this.title = title;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.notes = notes;
        this.address = address;
    }
}
