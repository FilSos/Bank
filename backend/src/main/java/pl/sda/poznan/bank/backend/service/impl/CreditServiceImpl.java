package pl.sda.poznan.bank.backend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.support.CronTrigger;
=======
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.poznan.bank.backend.exception.OperationException;
import pl.sda.poznan.bank.backend.model.AccountType;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.Credit;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.CreditRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;
<<<<<<< HEAD
import pl.sda.poznan.bank.backend.service.CreditInstallmentTask;
=======
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
import pl.sda.poznan.bank.backend.service.CreditService;
import pl.sda.poznan.bank.backend.web.viewmodel.CreditVM;

import java.time.LocalDate;

@Service
public class CreditServiceImpl implements CreditService {

    private BankAccountRepository bankAccountRepository;
    private UserRepository userRepository;
    private CreditRepository creditRepository;
    private InterestServiceImpl interestService;
<<<<<<< HEAD
    private TaskScheduler taskScheduler;
    private CronTrigger cronTrigger;
    private CreditInstallmentTask creditInstallmentTask;


    @Autowired
    public CreditServiceImpl(BankAccountRepository bankAccountRepository, UserRepository userRepository,
                             CreditRepository creditRepository, InterestServiceImpl interestService)
    {
=======


    @Autowired
    public CreditServiceImpl(BankAccountRepository bankAccountRepository, UserRepository userRepository, CreditRepository creditRepository, InterestServiceImpl interestService) {
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
        this.creditRepository = creditRepository;
        this.interestService = interestService;
<<<<<<< HEAD

=======
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
    }

    @Transactional(rollbackFor = OperationException.class)
    @Override
    public Boolean getCredit(CreditVM viewModel, long id) {

        String myAccountNumber = viewModel.getSourceAccountNumber();
<<<<<<< HEAD
        Long accountNumber = Long.valueOf(myAccountNumber);
        BankAccount Account = bankAccountRepository.findByAccountNumber(accountNumber);
=======
        BankAccount Account = bankAccountRepository.findByAccountNumber(myAccountNumber);
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749

        if (!(Account.getAccountType().equals(AccountType.PREMIUM))) {
            throw new OperationException("Nie mozna przydzielic kredytu");
        }

        Credit credit = new Credit();

        String startCreditDateBeforeParsing = viewModel.getStartCreditDate();
        LocalDate startCreditDate = LocalDate.parse(startCreditDateBeforeParsing);
        credit.setStartCreditDate(startCreditDate);

        String endCreditDateBeforeParsing = viewModel.getEndCreditDate();
        LocalDate endCreditDate = LocalDate.parse(endCreditDateBeforeParsing);
        credit.setEndCreditDate(endCreditDate);

<<<<<<< HEAD
        double creditBalance = Double.parseDouble(viewModel.getCreditBalance());
=======
        double creditBalance= Double.parseDouble(viewModel.getCreditBalance());
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
        credit.setCreditBalance(creditBalance);

        int installment = Integer.parseInt(viewModel.getInstallment());
        credit.setInstallment(installment);

        credit.setUser(userRepository.findById(id).orElse(null));

        creditRepository.save(credit);

<<<<<<< HEAD

        taskScheduler.schedule( creditInstallmentTask, cronTrigger = new CronTrigger("0 0 8 10 * ?"));
       /* taskScheduler.schedule(() -> {
            Credit credit = creditRepository.findOne(id);
            Double creditBalance = credit.getCreditBalance();
            Double interestValue = interestService.creditInterestCounter(credit);
            creditBalance -= creditBalance / interestValue;
        }, cronTrigger = new CronTrigger("0 0 8 10 * ?"));*/

        return true;
    }

    @Override
    public Runnable CreditInstallment(long id) {
        Credit credit = creditRepository.findOne(id);
        Double creditBalance = credit.getCreditBalance();
        Double interestValue = interestService.creditInterestCounter(credit);
        creditBalance -= creditBalance / interestValue;
        return new Thread();

    }

    public void CronCreditInstallment(long id){


    }
=======
        return true;
    }

//    @Scheduled(cron = "0 0 8 10 * ?")
@Override
public void CreditInstallment(long id){
    Credit credit = creditRepository.findOne(id);
    Double creditBalance = credit.getCreditBalance();
    Double interestValue = interestService.credtInterestCounter(credit);
    creditBalance -= creditBalance / interestValue;

    }

>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749

}

