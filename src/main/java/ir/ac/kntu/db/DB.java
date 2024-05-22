package ir.ac.kntu.db;

public class DB {

    private static AdminDB adminDB;
    private static CustomerDB customerDB;

    public DB(AdminDB adminDB, CustomerDB customerDB) {
        this.adminDB = adminDB;
        this.customerDB = customerDB;
    }

    public static AdminDB getAdminDB() {
        return adminDB;
    }

    public static CustomerDB getCustomerDB() {
        return customerDB;
    }
}
