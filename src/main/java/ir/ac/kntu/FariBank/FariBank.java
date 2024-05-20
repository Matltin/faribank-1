package ir.ac.kntu.FariBank;

import ir.ac.kntu.DB.AdminDB;
import ir.ac.kntu.DB.CustomerDB;
import ir.ac.kntu.DB.DB;

import java.util.HashSet;

public class FariBank {
    AdminDB adminDB = new AdminDB(new HashSet<>());
    CustomerDB customerDB = new CustomerDB(new HashSet<>());
    DB db = new DB(adminDB, customerDB);

}
