package bank.labs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccount {

    private Client client;

    public Double wpłata(Double amount) {
        Double saldo = client.getSaldo();
        if (amount != null && amount > 0)
            saldo += amount;
        System.out.println(saldo);
        return saldo;

    }

}

