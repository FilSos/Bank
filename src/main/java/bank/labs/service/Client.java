package bank.labs.service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;



public  class Client {

    private Integer id;
    private LocalDate dataZalozenia;
    private Double saldo;
    private AccountType accountType;
    private History history;
    private OperationHistory operationHistory;

    public Client(Integer id, LocalDate dataZalozenia, Double saldo, AccountType accountType) {
        this.id = id;
        this.dataZalozenia = dataZalozenia;
        this.saldo = saldo;
        this.accountType = accountType;
        this.operationHistory = new OperationHistory();
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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public OperationHistory getOperationHistory() {
        return operationHistory;
    }

    public void setOperationHistory(OperationHistory operationHistory) {
        this.operationHistory = operationHistory;
    }

}
