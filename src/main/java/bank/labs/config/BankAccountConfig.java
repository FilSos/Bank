package bank.labs.config;

import bank.labs.service.*;
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
    @Bean
    public History history(){
        return new History(OperationType.WPLATA,LocalDate.now(),"To jest opis wplaty");
    }
}
