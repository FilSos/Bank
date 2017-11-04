package bank.labs.service;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
@Component
public class Klient {

    private Integer id;

    private LocalDate dataZalozenia;
    private Double saldo;

    public Klient(Integer id, LocalDate dataZalozenia, Double saldo) {
        this.id = id;
        this.dataZalozenia = dataZalozenia;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(LocalDate dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
