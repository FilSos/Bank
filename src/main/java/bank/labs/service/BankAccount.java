package bank.labs.service;


import bank.labs.model.Client;
import bank.labs.model.History;
import bank.labs.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Component
public class BankAccount {
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private long accountId;
    @ManyToOne
    private Client client;

    HistoryService historyService;

    ClientService clientService;

    @Autowired
    public BankAccount(HistoryService historyService, ClientService clientService) {
        this.historyService = historyService;
        this.clientService = clientService;
    }


    public Double wpłata(Double amount) {
        Double saldo = client.getSaldo();
        if (amount != null && amount > 0)
            saldo += amount;
        client.setHistory(history);
        client.getOperationHistory().addHistory(client);
        System.out.println(saldo);
        return saldo;

    }

    public Double wypłata(Double amount) {
        Double saldo = client.getSaldo();
        if (amount != null && amount > 0)
            saldo -= amount;
        client.setHistory(history);
        client.getOperationHistory().addHistory(client);

        System.out.println(saldo);
        return saldo;

    }

    public Double przelew(Double amount, Client odbiorca) {
        Double saldo = client.getSaldo();
        if (amount != null && amount > 0)
            if (saldo != null && saldo > amount) {
                Double saldoOdbiorcy = odbiorca.getSaldo();
                saldoOdbiorcy += amount;
                client.setHistory(history);
                client.getOperationHistory().addHistory(client);
                saldo -= amount;

                System.out.println("saldo odbiorcy" + saldoOdbiorcy);
            }
        System.out.println("nasze saldo: " + saldo);

        return saldo;

    }


}

