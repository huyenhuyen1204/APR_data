public class BankException extends Exception{
    public String mess;

    public BankException() {

    }

    public BankException(String mess) {
        super(mess);
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }
}
