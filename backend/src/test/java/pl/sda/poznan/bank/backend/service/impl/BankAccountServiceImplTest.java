package pl.sda.poznan.bank.backend.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.poznan.bank.backend.model.*;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;
import pl.sda.poznan.bank.backend.service.BankAccountService;


import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
public class BankAccountServiceImplTest {


    @TestConfiguration
    static class BankAccountServiceImplTestContextConfiguration {

        @Bean
        public BankAccountService bankAccountService() {
            return new BankAccountServiceImpl();
        }
    }


    @Autowired
    private BankAccountService bankAccountService;

    @MockBean
    private HistoryRepository historyRepository;

    @MockBean
    private BankAccountRepository bankAccountRepository;
    @MockBean
    private UserRepository userRepository;


    @Test
    public void payment() throws Exception {
        BankAccount bankAccount = new BankAccount(AccountType.STANDARD,null,"61109010140000071219812874");
        double amount = 400.0;
        double balance = bankAccount.getBalance();
        balance+=amount;
        assertEquals("Should change account balance",amount,balance,0.0000000000000000000000001);

    }

        @Test
        public void payoff () throws Exception {
            BankAccount bankAccount = new BankAccount(AccountType.STANDARD,null,"61109010140000071219812874");
            double amount = 400.0;
            double balance = bankAccount.getBalance()+400;
            balance-=amount;
            assertEquals("Should change account balance",0,balance,0.0000000000000000000000001);
        }

        @Test
        public void transfer () throws Exception {
            BankAccount bankAccount = new BankAccount(AccountType.STANDARD,null,"61109010140000071219812874");
            BankAccount bankAccount2 = new BankAccount(AccountType.STANDARD,null,"32958930258230952029338503");
            double amount = 400.0;
            double balance = bankAccount.getBalance()+400;
            double balance2 = bankAccount2.getBalance() + 800;
            balance+=amount;
            balance2-=amount;
            assertEquals("Balance of first account changed",balance+=amount,balance,0.0000000000000000000000001);
            assertEquals("Balance of second account changed",balance2+=amount,balance2,0.0000000000000000000000001);
        }
    }