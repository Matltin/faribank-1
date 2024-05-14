package ir.ac.kntu.DB;

import ir.ac.kntu.FariBank.Account.Account;
import ir.ac.kntu.Person.Customer.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerDB {

    private Set<Customer> customers;

    public CustomerDB(Set<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Customer findCustomer(long accountNO) {
        for(Customer customer : customers) {
            if(customer.getAccount().getAccountNO() == accountNO) {
                return customer;
            }
        }
        return null;
    }
}
