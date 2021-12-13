import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 *   Predefined Class User :
 *
 *   Variables:
 *
 *              String userId:
 *
 *              String password:
 *
 *
 *
 *   Constructors:
 *
 *              User(String userName, String password):
 *
 *   Methods:
 *              getters & setters
 *
 *---------------------------------------------------------------------------------------------------------------
 *   Class Customer :
 *
 *   Variables:
 *
 *              float balance:
 *
 *              //List<Account>:
 *
 *              SavingAccount savingAccount:
 *
 *              CheckingAccount checkingAccount:
 *
 *              SecurityAccount securityAccount:
 *
 *   Constructors:
 *
 *              Customer(String customerId, String password)
 *
 *   Methods:
 *
 *              createccount(AccountType accountType, CurrencyType cType, double amount):
 *
 */

public class Customer extends User{

    private float balance;
    //private List<Account> accountList;
    private SavingAccount savingAccount;
    private CheckingAccount checkingAccount;
    private SecurityAccount securityAccount;

    public Customer(String customerId, String password){
        super(customerId, password);
    }


    public void  createccount(AccountType accountType, CurrencyType cType, double amount) throws IOException, URISyntaxException {

        switch(accountType)// set this.xxxAccount
        {
            case SAVING ->   this.savingAccount = new SavingAccount(cType, amount);

            case CHECKING -> this.checkingAccount = new CheckingAccount(cType, amount);

            case SECURITY -> this.securityAccount = new SecurityAccount(cType, amount);
        }

        // update to database
        if(!Database.getUsers().contains(this))
            Database.addUser(this);

        Database.WriteUserToLocal();

    }



}
