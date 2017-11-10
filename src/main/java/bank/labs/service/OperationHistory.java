package bank.labs.service;

import bank.labs.model.Client;
import bank.labs.model.History;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OperationHistory {

    private ArrayList<History> clientHistory = new ArrayList<>();

    public ArrayList<History> addHistory(Client client) {
        clientHistory.add(client.getHistory());
        return clientHistory;
    }
}
