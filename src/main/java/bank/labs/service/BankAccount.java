package bank.labs.service;


import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class BankAccount {
    private AccountType accountType;
    private Integer accountId;
    private Client client;

    @Autowired
    History history;

    public BankAccount(Client client) {
        this.client = client;
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

