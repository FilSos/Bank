package bank.labs.repository;

import bank.labs.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long> {
    Client findById(long id);
}
