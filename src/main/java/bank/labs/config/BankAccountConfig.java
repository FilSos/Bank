package bank.labs.config;

import bank.labs.service.AccountType;
import bank.labs.service.BankAccount;
import bank.labs.service.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class BankAccountConfig {
    @Bean
    public BankAccount bankAccount() {
        return new BankAccount(client());
    }

    @Bean
    public Client client()

    {
        return new Client(1, LocalDate.ofYearDay(2015,1),0.0, AccountType.STANDARD);
    }
}
