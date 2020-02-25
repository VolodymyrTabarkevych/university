package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sql.DataSource;

import ua.com.foxminded.university.DbTestData;
import ua.com.foxminded.university.dao.DbConnection;
import ua.com.foxminded.university.dao.DbCooperator;

public class ProgramMenu extends TextUniversityMenu {
    private DbConnection dbConnection;
    private DbTestData dbTestData;
    private DataSource dataSource;
    private DbCooperator dbCooperator;
    private UniversityMenu universityMenu;
    private TimetableMenu timetableMenu;

    public ProgramMenu() {
        this.dbConnection = new DbConnection();
        this.dbTestData = new DbTestData(dbConnection);
        this.dbConnection = dbTestData.createUniversetyDB();
        this.dataSource = dbConnection.init();
        this.dbCooperator = new DbCooperator(dataSource);
        this.universityMenu = new UniversityMenu(dbCooperator);
        this.timetableMenu = new TimetableMenu(dbCooperator);
    }

    public void start() {
        dbTestData.createData();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selectedOption = " ";

        while (!selectedOption.equals("")) {
            showOptions();
            try {
                selectedOption = reader.readLine();
                switch (selectedOption) {
                case "":
                    break;
                case "a":
                    showTimetableMenuOptions();
                    selectedOption = reader.readLine();
                    timetableMenu.start(selectedOption, reader);
                    break;
                case "b":
                    showUniversityMenuOptions();
                    selectedOption = reader.readLine();
                    universityMenu.start(selectedOption, reader);
                    break;
                default:
                    System.out.println(WRONG_INPUT);
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println(WRONG_INPUT);
            }
        }
    }
}
