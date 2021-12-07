/**
 *   Class ATM :
 *
 *
 *   Variables:
 *
 *              ArrayList<Account> accounts: all the accounts of the bank
 *
 *   Constructors:
 *
 *
 *   Methods:
 *
 *              boolean login():   prompt user + password, return true if valid, false otherwise
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
}
