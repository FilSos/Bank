package bank.labs.controller;

import bank.labs.service.BankAccount;
import bank.labs.service.Client;
import bank.labs.service.OperationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;


@Controller
public class BankAccountController {


    @Autowired
    BankAccount bankAccount;
    @Autowired
    Client client;
    @Autowired
    OperationHistory history;

    @GetMapping("/bank/wplata")
    public ModelAndView wplata(){
        bankAccount.wpłata(400.0);
        System.out.println("wiadomosc test");
        return new ModelAndView("start");
    }

    @GetMapping("/bank/wyplata")
    public ModelAndView wyplata(){
        bankAccount.wypłata(400.0);
        System.out.println("wiadomosc test2");
        return new ModelAndView("start");
    }

    @GetMapping("/bank/przelew")
    public ModelAndView przelew(){
        bankAccount.przelew(400.0,client);
        System.out.println("wiadomosc test3");
        return new ModelAndView("start");
    }

    @GetMapping("/bank/historia")
    public ModelAndView historia(){
        history.getHistory(client);
        System.out.println("wiadomosc test4");
        return new ModelAndView("start");
    }
    @
}
