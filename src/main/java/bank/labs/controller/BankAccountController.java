/*TODO Napisz oddzielne klasy z adnotacja getMapping ktore beda zwracaly pojedynczego klienta a pozniej wstrzykuj je
TODO w klasy ktore dodaja historie itd*/


package bank.labs.controller;

import bank.labs.service.BankAccount;
import bank.labs.model.Client;
import bank.labs.service.ClientService;
import bank.labs.service.OperationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/bank")
public class BankAccountController {

    BankAccount bankAccount;

    OperationHistory history;

    ClientService clientService;

    public BankAccountController(BankAccount bankAccount, OperationHistory history, ClientService clientService) {
        this.bankAccount = bankAccount;
        this.history = history;
        this.clientService = clientService;
    }

    @GetMapping("/wplata")
    public ModelAndView wplata() {
        bankAccount.wpłata(400.0);
        System.out.println("wiadomosc test");
        return new ModelAndView("start");
    }

    @GetMapping("/wyplata")
    public ModelAndView wyplata() {
        bankAccount.wypłata(400.0);
        System.out.println("wiadomosc test2");
        return new ModelAndView("start");
    }

    @GetMapping("/przelew")
    public ModelAndView przelew() {
        bankAccount.przelew(400.0, clientService.getClient(id));
        System.out.println("wiadomosc test3");
        return new ModelAndView("start");
    }


    @GetMapping("/history")
    public ModelAndView history() {
        history.addHistory(clientService.getClient(id));
        System.out.println("wiadomosc test5");
        return new ModelAndView("start");
    }
}
