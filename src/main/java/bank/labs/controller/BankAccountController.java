/*TODO Napisz oddzielne klasy z adnotacja getMapping ktore beda zwracaly pojedynczego klienta a pozniej wstrzykuj je
TODO w klasy ktore dodaja historie itd*/
//TODO popracuj nad bankAccount, zeby moc tworzyc jego instancje i wywolywac jego funkcje


package bank.labs.controller;

import bank.labs.service.BankAccount;
import bank.labs.model.Client;
import bank.labs.service.ClientService;
import bank.labs.service.OperationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/bank")
public class BankAccountController {

    BankAccount bankAccount;

    OperationHistory history;

    ClientService clientService;

    ClientController clientController;
    public BankAccountController( OperationHistory history, ClientService clientService, ClientController clientController) {
        this.history = history;
        this.clientService = clientService;
        this.clientController = clientController;
    }

    @Autowired(required = false)
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @PostMapping
    public ModelAndView wplata(@ModelAttribute Client client) {
        bankAccount.wpłata(400.0);
        System.out.println("wiadomosc test");
        return new ModelAndView("start");
    }
//TODO popraw na posta
    @GetMapping("/wyplata")
    public ModelAndView wyplata() {
        bankAccount.wypłata(400.0);
        System.out.println("wiadomosc test2");
        return new ModelAndView("start");
    }

    @PostMapping
    public ModelAndView przelew(@ModelAttribute Client client) {
        bankAccount.przelew(400.0, clientService.getClient(client.getId()));
        System.out.println("wiadomosc test3");
        return new ModelAndView("start");
    }


    @PostMapping
    public ModelAndView history(@ModelAttribute Client client) {
        history.addHistory(clientService.getClient(client.getId()));
        System.out.println("wiadomosc test5");
        return new ModelAndView("start");
    }
}
