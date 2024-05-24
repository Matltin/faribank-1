package ir.ac.kntu.menu.customer.customermenu;

import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.customer.accountmangemenu.AccountMangeMenu;
import ir.ac.kntu.menu.customer.contactmenu.ContactMenu;
import ir.ac.kntu.menu.customer.settingmenu.SettingMenu;
import ir.ac.kntu.menu.customer.support.SupportMenu;
import ir.ac.kntu.menu.customer.transfermoneymenu.TransferMenu;
import ir.ac.kntu.menu.customer.transfermoneymenu.TransferMenuOption;
import ir.ac.kntu.person.customer.Customer;

public class CustomerMenu extends Menu {

    private Customer customer;
    private TransferMenu transferMenu;
    private AccountMangeMenu accountMangeMenu;
    private ContactMenu contactMenu;
    private SupportMenu supportMenu;
    private SettingMenu settingMenu;

    public CustomerMenu(TransferMenu transferMenu, AccountMangeMenu accountMangeMenu, ContactMenu contactMenu, SupportMenu supportMenu, SettingMenu settingMenu) {
        this.transferMenu = transferMenu;
        this.accountMangeMenu = accountMangeMenu;
        this.contactMenu = contactMenu;
        this.supportMenu = supportMenu;
        this.settingMenu = settingMenu;
    }

    public void show(Customer customer){
        this.customer = customer;
        show();
    }

    @Override
    public void show() {
        System.out.println("customer Menu");
        CustomerMenuOption customerMenuOption = printMenuOption();
        while (customerMenuOption != CustomerMenuOption.BACK) {
            if (customerMenuOption != null) {
                switch (customerMenuOption) {
                    case TRANSFER_MONEY:
                        transferMenu.show(customer);
                        break;
                    case ACCOUNT_MANAGE:
                        accountMangeMenu.show(customer);
                        break;
                    case CONTACT_MENU:
                        contactMenu.show(customer);
                        break;
                    case SUPPORT:
                        supportMenu.show(customer);
                        break;
                    case SETTING:
                        settingMenu.show(customer);
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            customerMenuOption = printMenuOption();
        }
    }

    private CustomerMenuOption printMenuOption() {
        System.out.println("----------customer Menu----------");
        CustomerMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(CustomerMenuOption.class);
    }
}
