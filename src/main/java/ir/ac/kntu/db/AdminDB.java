package ir.ac.kntu.db;

import ir.ac.kntu.person.admin.Admin;

import java.util.Set;

public class AdminDB {

    private Set<Admin> admins;

    public AdminDB(Set<Admin> admins) {
        this.admins = admins;
        admins.add(new Admin("Matin", "Ahmadi", "1", "m"));

    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void removeAdmin() {
    }

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
