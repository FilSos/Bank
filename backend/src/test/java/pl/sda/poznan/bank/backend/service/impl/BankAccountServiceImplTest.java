package pl.sda.poznan.bank.backend.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.poznan.bank.backend.model.*;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;
import pl.sda.poznan.bank.backend.service.BankUserDetailsService;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;


import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class BankAccountServiceImplTest  {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private TestEntityManager entityManager;



    @Test
    public void payment() throws Exception {
        User user = new User("test","test","Jan","Kowalski",
                "test@gmail.com",true,null,UserType.USER,null, LocalDate.now());
        entityManager.persist(user);
        entityManager.flush();
        Optional<User> testUser = userRepository.findByLogin(user.getLogin());

        assertNotEquals(testUser,user.getLogin());

        BankAccount bankAccount = new BankAccount(AccountType.STANDARD,user,"61109010140000071219812874");
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