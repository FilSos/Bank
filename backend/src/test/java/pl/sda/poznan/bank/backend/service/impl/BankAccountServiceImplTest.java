package pl.sda.poznan.bank.backend.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.BankUserDetailsService;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceImplTest  {

    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankUserDetailsService bankUserDetailsService;

    @Mock
    DataSource dataBase;


    @Test
    public void payment() throws Exception {
        PaymentAndPayoffVM viewModel = new PaymentAndPayoffVM("61109010140000071219812874",
                400.0,"Info test");
        BankAccount byAccountNumber = bankAccountRepository.findByAccountNumber(viewModel.getSourceAccountNumber());
        double balance = byAccountNumber.getBalance();

        assertEquals(800.0,400.0);


    }

    @Test
    public void payoff() throws Exception {
        PaymentAndPayoffVM viewModel = new PaymentAndPayoffVM("61109010140000071219812874",
                400.0,"Info test");
    }

    @Test
    public void transfer() throws Exception {
    }

    @Test
    public void getUserAccounts() throws Exception {
    }

}