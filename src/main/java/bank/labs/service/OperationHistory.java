package bank.labs.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OperationHistory {

    ArrayList<History> HistoriaKlienta;


    public ArrayList<History> getHistory(Client client) {
        for (History Lista : HistoriaKlienta) {
            System.out.println(Lista.getOperationDate());
        }
        return HistoriaKlienta;
    }

    public ArrayList<History> addHistory(Client client) {
        HistoriaKlienta.add(client.getHistory());
        return HistoriaKlienta;
    }
}
