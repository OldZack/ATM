import java.util.List;

/**
 *   Class Customer :
 *
 *   Variables:
 *
 *              float balance:
 *
 *              ArrayList<Account>:
 *
 *   Constructors:
 *
 *
 *   Methods:
 *
 *              createAccount(): create checking and savings accounts
 *
 *              closeAccount():
 *
 *
 *
 */

public class Customer extends User{

    private float balance;
    private List<Account> accountList;
    private SavingAccount savingAccount;
    private CheckingAccount checkingAccount;
    private SecurityAccount securityAccount;

    public Customer(String customerId, String password){
        super(customerId, password);
    }



}
