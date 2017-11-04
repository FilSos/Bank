package bank.labs.service;

import java.time.LocalDate;



public  class Client {

    private Integer id;
    private LocalDate dataZalozenia;
    private Double saldo;
    private BankAccount bankAccount;

    public Client(Integer id, LocalDate dataZalozenia, Double saldo, BankAccount bankAccount) {
        this.id = id;
        this.dataZalozenia = dataZalozenia;
        this.saldo = saldo;
        this.bankAccount = bankAccount;
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
