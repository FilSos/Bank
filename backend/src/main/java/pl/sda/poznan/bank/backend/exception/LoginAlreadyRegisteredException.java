package pl.sda.poznan.bank.backend.exception;

public class LoginAlreadyRegisteredException extends SdaBankApplicationException{
<<<<<<< HEAD
    public LoginAlreadyRegisteredException() {
        super("Login already registered");
    }

=======
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749
    public LoginAlreadyRegisteredException(String message) {
        super(message);
    }

    public LoginAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
