package ir.ac.kntu.faribank;

import ir.ac.kntu.db.AdminDB;
import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.db.CustomerDB;
import ir.ac.kntu.menu.admin.adminmenu.AdminMenu;
import ir.ac.kntu.menu.admin.branch.BranchMenu;
import ir.ac.kntu.menu.admin.loginadminmenu.LoginAdminMenu;
import ir.ac.kntu.menu.admin.requstmenu.RequestAdminMenu;
import ir.ac.kntu.menu.admin.searchmenu.SearchMenu;
import ir.ac.kntu.menu.admin.searchusermenu.SearchUserMenu;
import ir.ac.kntu.menu.admin.statemenu.StateMenu;
import ir.ac.kntu.menu.admin.useraccessmenu.UserAccessMenu;
import ir.ac.kntu.menu.customer.accountmangemenu.AccountMangeMenu;
import ir.ac.kntu.menu.customer.contactmenu.ContactMenu;
import ir.ac.kntu.menu.customer.customermenu.CustomerMenu;
import ir.ac.kntu.menu.customer.logincustomermenu.LoginCustomerMenu;
import ir.ac.kntu.menu.customer.requestmenu.RequestCustomerMenu;
import ir.ac.kntu.menu.customer.settingmenu.SettingMenu;
import ir.ac.kntu.menu.customer.support.SupportMenu;
import ir.ac.kntu.menu.customer.transfermoneymenu.TransferMenu;
import ir.ac.kntu.menu.mainmenu.MainMenu;

import java.util.ArrayList;
import java.util.HashSet;

public class FariBank {

    private MainMenu mainMenu;

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
//        DataBase dataBase = new DataBase(adminDB, customerDB);
        AdminMenu adminMenu = new AdminMenu(customerDB, requestAdminMenu, userAccessMenu);
        RequestCustomerMenu requestCustomerMenu = new RequestCustomerMenu(answerDB);
        TransferMenu transferMenu = new TransferMenu(customerDB);
        AccountMangeMenu accountMangeMenu = new AccountMangeMenu(customerDB);
        ContactMenu contactMenu = new ContactMenu(customerDB);
        SupportMenu supportMenu = new SupportMenu(requestCustomerMenu);
        SettingMenu settingMenu = new SettingMenu();
        CustomerMenu customerMenu = new CustomerMenu(transferMenu, accountMangeMenu, contactMenu, supportMenu, settingMenu);
        LoginAdminMenu loginAdminMenu = new LoginAdminMenu(adminDB, adminMenu);
        LoginCustomerMenu loginCustomerMenu = new LoginCustomerMenu(customerDB, customerMenu);
        mainMenu = new MainMenu(loginAdminMenu, loginCustomerMenu);


    }


}
