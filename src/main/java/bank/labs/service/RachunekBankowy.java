package bank.labs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RachunekBankowy {

    @Autowired
    Klient klient;

    public Double wpłata(Double kwota) {
        Double saldo = klient.getSaldo();
        if (kwota != null && kwota > 0)
            saldo += kwota;
        return saldo;

    }

}

