package bank.labs.controller;

import bank.labs.service.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BankAccountController {


    @Autowired
    BankAccount bankAccount;

    @GetMapping("/bank")
    public ModelAndView homePage(){
        bankAccount.wpłata(400.0);
        System.out.println("wiadomosc test");
        return new ModelAndView("start");
    }
}
