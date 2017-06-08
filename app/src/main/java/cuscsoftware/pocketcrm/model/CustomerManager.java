package cuscsoftware.pocketcrm.model;

import java.util.ArrayList;

/**
 * Created by Lam Thanh Huy on 2017/06/08.
 */

public class CustomerManager {
    public ArrayList<Customer> loadCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        for (int i = 1; i < 50; i++) {
            Customer customer = new Customer("Customer " + String.valueOf(i), "090123456"+String.valueOf(i));
            customers.add(customer);
        }
        return  customers;
    }
}
