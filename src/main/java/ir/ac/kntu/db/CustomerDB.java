package ir.ac.kntu.db;

import ir.ac.kntu.person.customer.Customer;

import java.util.Set;

public class CustomerDB {

    private Set<Customer> customers;

    public CustomerDB(Set<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);

//        Customer customer1 = new Customer("a", "a", "Mm@1383", "12", "09102607040");
//        Customer customer2 = new Customer("b", "b", "Rr@1384", "13", "09112607040");
//        Customer customer3 = new Customer("c", "c", "Cc@1383", "14", "09122607040");
//
//
//        customers.add(customer1);
//        customers.add(customer2);
//        customers.add(customer3);

    }

    public void removeCustomer(Customer customer) {
        try {
            if (doesExist(customer)) {
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

    public int size() {
        return customers.size();
    }
}
