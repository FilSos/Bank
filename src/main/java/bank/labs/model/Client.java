package bank.labs.model;

import bank.labs.service.OperationHistory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
public  class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAccountStart;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @OneToMany
    private History history;
    private OperationHistory operationHistory;

    private  BankAccount bankAccount;

    private long amount;

    public Client() {
    }

    public Client(long id, LocalDate dateAccountStart, AccountType accountType, long amount, OperationHistory operationHistory, BankAccount bankAccount) {
        this.id = id;
        this.dateAccountStart = dateAccountStart;
        this.accountType = accountType;
        this.amount = amount;
        this.operationHistory = operationHistory;
        this.bankAccount = bankAccount;
    }

}
