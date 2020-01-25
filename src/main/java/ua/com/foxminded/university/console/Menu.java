package ua.com.foxminded.university.console;

import ua.com.foxminded.university.dao.DbConnection;
import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.ObjectFinder;

class Menu {
    static final String WRONG_INPUT = "------------------------------" + System.lineSeparator() + "Wrong input!"
            + System.lineSeparator() + "------------------------------";
    static final String CONTINUE_ADDING = "Do you want to continue adding(any button/enter for exit)?";
    static final String CONTINUE_REMOVING = "Do you want to continue removing(any button/enter for exit)?";
    static final String CONTINUE_CHANGING = "Do you want to continue changing(any button/enter for exit)?";
    DbConnection dbConnection = new DbConnection();
    DbCooperator dbCooperator = new DbCooperator(dbConnection.init());
    TextUniversityMenu textMenu = new TextUniversityMenu();
    ObjectFinder finder;

    public Menu() {
        // finder = new ObjectFinder(university);
    }

    Boolean checkIfBackMenu(String selectedOption) {
        return selectedOption.equals("p");
    }
}
