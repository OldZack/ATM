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
 *              boolean customerLogin(String customerID, String password){
 *
 *              boolean managerLogin(String managerID, String password){
 *
 *
 *
 *
 *
 *
 */

public class ATM {
    private static ATM instance;
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

    public User getCurrUser() { return currUser;}

    public CustomerDao getCustomerDao(){return customerDao; }

    public ManagerDao getManagerDao(){return managerDao; }

    public static ATM getInstance(){
        if (instance == null){
            instance = new ATM();
        }
        return instance;
    }

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
