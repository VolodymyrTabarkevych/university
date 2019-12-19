package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramMenu extends Menu {
	UniversityMenu universityMenu = new UniversityMenu();
	TimetableMenu timetableMenu = new TimetableMenu();

	public void start() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String selectedOption = " ";

		while (!selectedOption.equals("")) {
			textMenu.showOptions();
			try {
				selectedOption = reader.readLine();
				if (selectedOption.equals("a") || selectedOption.equals("b")) {
					if (selectedOption.equals("a")) {
						textMenu.showTimetableMenuOptions();
						selectedOption = reader.readLine();
						timetableMenu.start(selectedOption, reader);
					} else {
						textMenu.showUniversityMenuOptions();
						selectedOption = reader.readLine();
						universityMenu.start(selectedOption, reader);
					}
				}
			} catch (NumberFormatException | IOException e) {
				System.out.println(WRONG_INPUT);
			}
		}
	}
}
