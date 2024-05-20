package ir.ac.kntu.DB;

import ir.ac.kntu.Person.Admin.Admin;
import ir.ac.kntu.Person.Customer.Customer;

import java.util.HashSet;
import java.util.Set;

public class AdminDB {

    private Set<Admin> admins;

    public AdminDB(Set<Admin> admins) {
        this.admins = admins;
        admins.add(new Admin("matin", "ahmadi", "M@tin11383", "matltin"));
        admins.add(new Admin("reyhane", "arabshahi", "Rr@1383", "pota"));
    }

    public void addAdmin() {}
    public void removeAdmin() {}

    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }

    public Admin findAdmin(String username) {
        for (Admin admin : admins) {
            if (admin.getUserName().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    public boolean doesExist(Admin admin) {
        return admins.contains(admin);
    }
}
