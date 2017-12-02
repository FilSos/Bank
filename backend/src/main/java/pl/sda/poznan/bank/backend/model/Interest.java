package pl.sda.poznan.bank.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Interest {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double interestInPercent;
<<<<<<< HEAD
    @OneToOne
=======
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
    private Investment investmentBalance;
    private AccountType accountType;
}
