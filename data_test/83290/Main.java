public class Main {

    public static void main(String[] args) {
	// write your code here
        Account acc= new Account();
        acc.addTransaction(1000,"deposit");
        acc.printTransaction();
    }
}
