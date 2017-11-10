package bank.labs.service;

import bank.labs.model.Client;
import bank.labs.model.History;
import bank.labs.repository.ClientRepository;
import bank.labs.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {

    private ClientRepository clientRepository;

    private HistoryRepository historyRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, HistoryRepository historyRepository) {
        this.clientRepository = clientRepository;
        this.historyRepository = historyRepository;
    }


    public List<Client>getAllClients(){
       return (List<Client>)clientRepository.findAll();

    }
    public  Client getClient(int id){
        return (Client) clientRepository.findById(id);
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
    public List<History> clientHistory(int id){
       return historyRepository.findByClientId(id);
    }
}
