package bank.labs.model;

import bank.labs.service.ClientService;
import bank.labs.service.HistoryService;
import bank.labs.service.OperationHistory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class BankAccount {
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private long accountId;

    @ManyToOne
    private Client client;

    private double balance;

    private HistoryService historyService;

    private ClientService clientService;

    private OperationHistory operationHistory;

    @Autowired
    public BankAccount(AccountType accountType, HistoryService historyService,
                       ClientService clientService, OperationHistory operationHistory) {
        this.accountType = accountType;
        this.accountId = client.getId();
        this.historyService = historyService;
        this.clientService = clientService;
        this.operationHistory = operationHistory;
        this.balance = 0;


    }
}
