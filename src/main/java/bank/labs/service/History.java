package bank.labs.service;

import java.time.LocalDate;

public class History {

    private OperationType operationType;
    private LocalDate operationDate;
    private String description;


    public History(OperationType operationType, LocalDate operationDate, String description) {
        this.operationType = operationType;
        this.operationDate = operationDate;
        this.description = description;

    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
