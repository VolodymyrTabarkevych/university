package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgramMenu extends MenuText {
    private static final Logger logger = LoggerFactory.getLogger(ProgramMenu.class);
    @Autowired
    private UniversityMenu universityMenu;
    @Autowired
    private TimetableMenu timetableMenu;

    public void run() {
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
                        System.err.println(WRONG_INPUT);
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
                System.err.println(WRONG_INPUT + e.getMessage());
            }
        } while (!selectedOption.equals(""));
    }
}
