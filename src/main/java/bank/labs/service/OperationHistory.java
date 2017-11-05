package bank.labs.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OperationHistory {

    ArrayList<History> HistoriaKlienta = new ArrayList<>();

    public ArrayList<History> addHistory(Client client) {
        HistoriaKlienta.add(client.getHistory());
        return HistoriaKlienta;
    }
}
