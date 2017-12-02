package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.Credit;
import pl.sda.poznan.bank.backend.model.Interest;
import pl.sda.poznan.bank.backend.model.Investment;

public interface InterestService {
<<<<<<< HEAD
    Double creditInterestCounter(Credit credit);
=======
    Double credtInterestCounter(Credit credit);
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749

    Double investmentInterestCounter(Investment investment);
}
