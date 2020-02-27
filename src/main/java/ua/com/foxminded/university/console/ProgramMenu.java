package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sql.DataSource;

import ua.com.foxminded.university.SampleUniversityData;
import ua.com.foxminded.university.UniversityDatabase;
import ua.com.foxminded.university.DbConnection;
import ua.com.foxminded.university.DbCooperator;

public class ProgramMenu extends TextUniversityMenu {
    private DbConnection dbConnection;
    private UniversityDatabase universityDatabase;
    private DataSource dataSource;
    private DbCooperator dbCooperator;
    private UniversityMenu universityMenu;
    private TimetableMenu timetableMenu;
    private SampleUniversityData sampleUniversityData;

    public ProgramMenu() {
        this.dbConnection = new DbConnection();
        this.universityDatabase = new UniversityDatabase(dbConnection);
        this.dataSource = universityDatabase.createDatabase();
        this.dbCooperator = new DbCooperator(dataSource);
        this.universityMenu = new UniversityMenu(dbCooperator);
        this.timetableMenu = new TimetableMenu(dbCooperator);
        this.sampleUniversityData = new SampleUniversityData(dataSource);
    }

    public void start() {
        sampleUniversityData.loadIntoDatabase();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String selectedOption = "";

        do {
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
        } while (!selectedOption.equals(""));
    }
}
