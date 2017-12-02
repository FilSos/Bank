package pl.sda.poznan.bank.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import pl.sda.poznan.bank.backend.exception.EmailAlreadyRegisteredException;
=======
import pl.sda.poznan.bank.backend.exception.UserNotFoundException;
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
import pl.sda.poznan.bank.backend.model.BankUserPrincipal;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.UserRepository;

@Service
public class BankUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public BankUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
<<<<<<< HEAD
        User user = userRepository.findByLogin(login).orElseThrow(EmailAlreadyRegisteredException::new);
=======
        User user = userRepository.findByLogin(login).orElse(null);
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
        return new BankUserPrincipal(user);
    }
}
