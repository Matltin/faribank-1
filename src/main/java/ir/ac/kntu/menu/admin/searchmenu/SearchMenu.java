package ir.ac.kntu.menu.admin.searchmenu;

import ir.ac.kntu.menu.Menu;

public class SearchMenu extends Menu {
    @Override
    public void show() {
        System.out.println("search menu");
        SearchMenuOption searchMenuOption = printMenuOption();
        while (searchMenuOption != SearchMenuOption.BACK) {
            if(searchMenuOption != null) {
                switch (searchMenuOption) {
                    case STATE:
                    case BRANCH:
                    case USER:
                    default:
                        break;
                }
            } else {
                System.out.println("invalid input!!");
            }
            searchMenuOption = printMenuOption();
        }

    }

    private SearchMenuOption printMenuOption() {
        System.out.println("----------request Menu----------");
        SearchMenuOption.printOption();
        System.out.print("Enter your choice : ");
        return getOption(SearchMenuOption.class);
    }
}
