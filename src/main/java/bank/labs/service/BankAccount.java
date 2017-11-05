package bank.labs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//@Component
public class BankAccount {
    private AccountType accountType;
    private Integer accountId;
    private Client clientId;

    @Autowired
    History history;


    public BankAccount(Client client) {
        this.clientId = client;
    }

    public Double wpłata(Double amount) {
        Double saldo = clientId.getSaldo();
        if (amount != null && amount > 0)
            saldo += amount;
            clientId.setHistory(history);
        System.out.println(saldo);
        return saldo;

    }

    public Double wypłata(Double amount) {
        Double saldo = clientId.getSaldo();
        if (amount != null && amount > 0)
            saldo -= amount;
        clientId.setHistory(history);
        System.out.println(saldo);
        return saldo;

    }

    public Double przelew(Double amount, Client odbiorca) {
        Double saldo = clientId.getSaldo();
        if (amount != null && amount > 0)
            if (saldo != null && saldo > amount) {
                Double saldoOdbiorcy = odbiorca.getSaldo();
                saldoOdbiorcy += amount;
                clientId.setHistory(history);
                saldo -= amount;

                System.out.println("saldo odbiorcy" + saldoOdbiorcy);
            }
        System.out.println("nasze saldo: " + saldo);

        return saldo;

    }


}

