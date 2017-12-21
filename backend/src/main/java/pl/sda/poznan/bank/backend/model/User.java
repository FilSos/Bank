package pl.sda.poznan.bank.backend.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean activated;

    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccount;


    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private List<History> history;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAccountStart;


    public User(String login, String password, String firstName, String lastName, String email, Boolean activated, List<BankAccount> bankAccount, UserType userType, List<History> history, LocalDate dateAccountStart) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.bankAccount = bankAccount;
        this.userType = userType;
        this.history = history;
        this.dateAccountStart = dateAccountStart;
    }
}
