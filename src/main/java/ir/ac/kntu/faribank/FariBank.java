package ir.ac.kntu.faribank;

import ir.ac.kntu.db.AdminDB;
import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.db.DB;

import java.util.HashSet;

public class FariBank {
    AdminDB adminDB = new AdminDB(new HashSet<>());
    CustomerDB customerDB = new CustomerDB(new HashSet<>());
    DB db = new DB(adminDB, customerDB);

}
