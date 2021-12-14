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

    //private float balance;
    //private List<Account> accountList;
    private SavingAccount savingAccount;
    private CheckingAccount checkingAccount;
    private SecurityAccount securityAccount;

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public SecurityAccount getSecurityAccount() {
        return securityAccount;
    }

    public void setSecurityAccount(SecurityAccount securityAccount) {
        this.securityAccount = securityAccount;
    }


    public Customer(String customerId, String password){
        super(customerId, password);
    }


    public void  createAccount(AccountType accountType, CurrencyType cType, double amount) throws IOException, URISyntaxException {

        switch(accountType)// set this.xxxAccount
        {
            case SAVING -> {
                this.savingAccount = new SavingAccount(cType, amount,this.getUserName());

                break;
            }

            case CHECKING -> {
                this.checkingAccount = new CheckingAccount(cType, amount,this.getUserName());
                break;
            }

            case SECURITY -> {
                this.securityAccount = new SecurityAccount(cType, amount,this.getUserName());
                break;
            }
        }

        // update to database
        if(Database.getUsers().get(this.getUserName())==null) {
            Database.addUser(this);
        }

        Database.WriteUserToLocal(this.getUserName());

    }

    public void  close(AccountType accountType, CurrencyType cType) throws IOException, URISyntaxException
    {
        switch(accountType)// set this.xxxAccount
        {
            case SAVING -> {
                this.savingAccount.closeAccount(cType);
                this.savingAccount=null;
                break;
            }

            case CHECKING -> {
                this.checkingAccount.closeAccount(cType);
                this.checkingAccount=null;
                break;
            }

            case SECURITY -> {
                this.securityAccount.closeAccount(cType);
                this.securityAccount=null;
                break;
            }
        }

        // update to database
        if(Database.getUsers().get(this.getUserName())==null) {
            Database.addUser(this);
        }

        Database.WriteUserToLocal(this.getUserName());

    }



}
