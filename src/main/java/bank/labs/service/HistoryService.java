package bank.labs.service;

import bank.labs.model.Client;
import bank.labs.model.History;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.OneToOne;
import java.util.ArrayList;

@Getter
public class HistoryService {

    private BankAccount bankAccount;

    private OperationHistory operationHistory;

    private ClientService clientService;

    @OneToOne
    private Client client;



    @Autowired
    public HistoryService(BankAccount bankAccount, OperationHistory operationHistory, ClientService clientService) {
        this.bankAccount = bankAccount;
        this.operationHistory = operationHistory;
        this.clientService = clientService;
    }

}
