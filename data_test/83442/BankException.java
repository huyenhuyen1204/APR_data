public class BankException extends Exception{
    protected String mess;

    public BankException() {

    }
    public BankException(String mess) {
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }
}
