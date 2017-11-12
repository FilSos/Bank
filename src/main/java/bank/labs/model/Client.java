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

    private Double saldo;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @OneToMany
    private History history;

    private OperationHistory operationHistory;

    private long amount;

    public Client() {
    }

    public Client(long id, LocalDate dateAccountStart, Double saldo, AccountType accountType, long amount, OperationHistory operationHistory) {
        this.id = id;
        this.dateAccountStart = dateAccountStart;
        this.saldo = saldo;
        this.accountType = accountType;
        this.amount = amount;
        this.operationHistory = operationHistory;
    }

}
