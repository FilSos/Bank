package bank.labs.config;

import bank.labs.service.BankAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccountConfig {
    @Bean
public BankAccount bankAccount(){
    return new BankAccount();
}
}
