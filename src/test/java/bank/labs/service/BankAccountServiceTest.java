package bank.labs.service;

import bank.labs.model.AccountType;
import bank.labs.model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BankAccountServiceTest {
    @Test
    public void wpłata() throws Exception {
        Client client = new Client(1, LocalDate.now(),1000.0, AccountType.VIP);
        BankAccountService bankAccountService = new BankAccountService(client);
        bankAccountService.wpłata(400.0);
        //Poprawic
        Assert.assertEquals(1400.0,1400.0,0.01);
    }

    @Test
    public void wypłata() throws Exception {
        Client client = new Client(1, LocalDate.now(),1000.0,AccountType.VIP);
        BankAccountService bankAccountService = new BankAccountService(client);
        bankAccountService.wypłata(400.0);
        //Poprawic
        Assert.assertEquals(600,600,0.01);
    }

    @Test
        public void przelew() throws Exception {
        Client client = new Client(1, LocalDate.now(),1000.0,AccountType.VIP);
        Client client2 = new Client(2, LocalDate.now(),1200.0,AccountType.VIP);
        BankAccountService bankAccountService = new BankAccountService(client);
        bankAccountService.przelew(400.0,client2);
        //Poprawic
        Assert.assertEquals(1400,1400,0.01);


    }

}