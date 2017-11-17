package bank.labs.service;


import bank.labs.model.AccountType;
import bank.labs.model.Client;
import bank.labs.model.History;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
public class BankAccount {
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private long accountId;
    @ManyToOne
    private Client client;

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

    }

    public void setAccountId() {
        this.accountId = client.getId();
    }

    //TODO pozmieniaj nazwy metdoy, BankAccount do modelu dodaj, i wtedy controllery powinny dziaqlac
    @Bean
    public Boolean contribution(Double amount) {
        Double saldo = client.getSaldo();
        if (amount != null && amount > 0) {

            saldo += amount;
            System.out.println(saldo);
            History history = new History(OperationType.CONTRIBUTION, LocalDate.now(),
                    "Dokonano operacji wpłaty dnia: " + LocalDate.now() + " na kwotę " + amount);
            client.setHistory(history);
            History oneHistory = client.getHistory();
            operationHistory.addHistory(oneHistory);
            return true;
        }
        return false;
    }

    @Bean
    public Boolean payoff(Double amount) {
        Double saldo = client.getSaldo();
        if (amount != null && amount > 0) {
            saldo -= amount;
            History history = new History(OperationType.CONTRIBUTION, LocalDate.now(),
                    "Dokonano operacji wypłaty dnia: " + LocalDate.now() + " na kwotę " + amount);
            client.setHistory(history);
            History oneHistory = client.getHistory();
            operationHistory.addHistory(oneHistory);
            return true;
        }
        return false;

    }

    //TODO nalezy otworzyc sesje i jesli wszystkie operacje nie wyjda, nalezy wykonac rollback
    @Bean
    public Boolean payment(Double amount, Client secondClient) {
        Double saldo = client.getSaldo();
        if (amount != null && amount > 0) {
            if (saldo != null && saldo > amount) {
                Double secondClientSaldo = secondClient.getSaldo();
                secondClientSaldo += amount;
                saldo -= amount;
                History history = new History(OperationType.CONTRIBUTION, LocalDate.now(),
                        "Dokonano operacji przelewu dnia: " + LocalDate.now() + " na kwotę " + amount);
                client.setHistory(history);
                History oneHistory = client.getHistory();
                operationHistory.addHistory(oneHistory);

                return true;
            }
        }

        return false;

    }


}

