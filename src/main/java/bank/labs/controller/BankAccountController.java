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

    @GetMapping("/new")
    public ModelAndView homePage(){
        bankAccount.wpłata(500.0);

        return new ModelAndView("home");
    }
}
