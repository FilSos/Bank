package pl.sda.poznan.bank.backend.exception;

public class EmailAlreadyRegisteredException extends SdaBankApplicationException {
<<<<<<< HEAD
    public EmailAlreadyRegisteredException() {
        super("Email Already Registered");
    }
=======
>>>>>>> 9048659537a547e44ba87947a8e2d8de82a32749

    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }

    public EmailAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
