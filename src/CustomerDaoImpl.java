import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    List<Customer> customers;

    public CustomerDaoImpl(){
        customers = new ArrayList<Customer>();
        Customer customer1 = new Customer("test1", "test1");
        Customer customer2 = new Customer("test2", "test2");
        addCustomer(customer1);
        addCustomer(customer2);
    }

    @Override
    public List<Customer> getAllCustomers(){
        return customers;
    }

    @Override
    public Customer getCustomer(String customerID){
        for(Customer customer: customers){
            if (customer.getUserName().equals(customerID)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer){
        customers.add(customer);

        FileUtils.writeCustomer(customers);

    }

    @Override
    public void removeCustomer(Customer customer){

    }

    @Override
    public boolean generateCustomer(String ID, String password){
        Customer customer = getCustomer(ID);
        if (customer != null){
            return false;
        }else{
            customer = new Customer(ID, password);
            customers.add(customer);
            FileUtils.writeCustomer(customers);
        }
        return true;
    }

    @Override
    public Customer searchCustomer(String ID, String password){
        for (Customer customer: customers){
            if (customer.getUserName().equals(ID) && customer.getPassword().equals(password)){
                return customer;
            }
        }
        return null;
    }
}
