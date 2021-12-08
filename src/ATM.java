/**
 *   Class ATM :
 *
 *
 *   Variables:
 *
 *              static ATM atm = new ATM()
 *
 *              User currUser:
 *
 *              Account currAccount:
 *
 *              CustomerDao customerDao:
 *
 *              ManagerDao managerDao;
 *   Constructors:
 *
 *
 *   Methods:
 *
 *              boolean login():   prompt user + password, return true if valid, false otherwise
 *
 *              void registerNewCustomer():     Add a new Customer object to DataBase
 *
 *              void askNewActionAfterLogin():
 *
 *
 *
 *
 */

public class ATM {
    private static ATM atm = new ATM();
    private User currUser;
    private Account currAccount;
    private CustomerDao customerDao;
    private ManagerDao managerDao;

    public ATM(){
        this.currUser = null;
        this.currAccount = null;
        this.customerDao = new CustomerDaoImpl();
        this.managerDao = new ManagerDaoImpl();
    }

    public static ATM getInstance(){ return atm; }

    public boolean customerLogin(String customerID, String password){
        Customer customer = customerDao.searchCustomer(customerID, password);
        if (customer == null){
            return false;
        }
        currUser = customer;
        return true;
    }

    public boolean managerLogin(String managerID, String password){
        Manager manager = managerDao.searchManager(managerID, password);
        if (manager == null){
            return false;
        }
        currUser = manager;
        return true;
    }

    public void askNewActionAfterLogin()
    {
        if(currAccount instanceof CheckingAccount)
        {

        }
        else if(currAccount instanceof  SavingAccount)
        {

        }
        else if (currAccount instanceof SecurityAccount)
        {

        }

    }
}
