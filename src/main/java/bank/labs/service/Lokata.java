package bank.labs.service;

public class Lokata {

    public Double lokata(Double amount, Client client){
        if(client.getAccountType().equals("LOKATA")){
            if(amount != null && amount > 0){
                Double saldo = client.getSaldo();
                saldo+=amount;
                System.out.println("Dokonano wplaty " + amount + ". Saldo: " + saldo);
            }
        }
        return client.getSaldo();
    }
}
