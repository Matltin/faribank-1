package ir.ac.kntu.DB;

import ir.ac.kntu.Person.Customer.Customer;

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
        try{
            if(doesExist(customer)) {
                customers.remove(customer);
            } else {
                throw new RuntimeException("customer not found!!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Customer findCustomer(String accountNO) {
        for (Customer customer : customers) {
            if (customer.getAccount().getAccountNO().equals(accountNO)) {
                return customer;
            }
        }
        return null;
    }

    public boolean doesExist(Customer customer) {
        return customers.contains(customer);
    }
}
