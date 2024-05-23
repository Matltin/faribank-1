package ir.ac.kntu.faribank;

import ir.ac.kntu.db.AdminDB;
import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.db.DataBase;
import ir.ac.kntu.menu.admin.adminmenu.AdminMenu;
import ir.ac.kntu.menu.admin.branch.BranchMenu;
import ir.ac.kntu.menu.admin.loginadminmenu.LoginAdminMenu;
import ir.ac.kntu.menu.admin.requstmenu.RequestAdminMenu;
import ir.ac.kntu.menu.admin.searchmenu.SearchMenu;
import ir.ac.kntu.menu.admin.searchusermenu.SearchUserMenu;
import ir.ac.kntu.menu.admin.statemenu.StateMenu;
import ir.ac.kntu.menu.admin.useraccessmenu.UserAccessMenu;
import ir.ac.kntu.menu.customer.customermenu.CustomerMenu;
import ir.ac.kntu.menu.customer.logincustomermenu.LoginCustomerMenu;
import ir.ac.kntu.menu.mainmenu.MainMenu;

import java.util.ArrayList;
import java.util.HashSet;

public class FariBank {

    MainMenu mainMenu;

    public void start() {
        initialize();
        mainMenu.show();
    }

    public void initialize() {
        AdminDB adminDB = new AdminDB(new HashSet<>());
        CustomerDB customerDB = new CustomerDB(new HashSet<>());

        AnswerDB answerDB = new AnswerDB(new ArrayList<>());

        SearchUserMenu searchUserMenu = new SearchUserMenu(customerDB);
        StateMenu stateMenu = new StateMenu(answerDB);
        BranchMenu branchMenu = new BranchMenu(answerDB);

        SearchMenu searchMenu = new SearchMenu(answerDB, stateMenu, branchMenu);

        RequestAdminMenu requestAdminMenu = new RequestAdminMenu(answerDB, searchMenu);

        UserAccessMenu userAccessMenu = new UserAccessMenu(customerDB, searchUserMenu);
        DataBase dataBase = new DataBase(adminDB, customerDB);
        AdminMenu adminMenu = new AdminMenu(customerDB, requestAdminMenu, userAccessMenu);
        CustomerMenu customerMenu = new CustomerMenu(customerDB);

        LoginAdminMenu loginAdminMenu = new LoginAdminMenu(adminDB, adminMenu);
        LoginCustomerMenu loginCustomerMenu = new LoginCustomerMenu(customerDB);



         mainMenu = new MainMenu(loginAdminMenu, loginCustomerMenu);



    }



}
