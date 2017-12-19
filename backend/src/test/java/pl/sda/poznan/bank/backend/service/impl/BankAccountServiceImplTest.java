package pl.sda.poznan.bank.backend.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.BankUserDetailsService;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;

import static org.junit.Assert.*;

public class BankAccountServiceImplTest {

    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankUserDetailsService bankUserDetailsService;


    @Test
    public void payment() throws Exception {
        PaymentAndPayoffVM viewModel = new PaymentAndPayoffVM("61109010140000071219812874",
                400.0,"Info test");
        bankAccountRepository.findByAccountNumber(viewModel.getSourceAccountNumber());
        assertNotNull("Account must exists",viewModel);

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