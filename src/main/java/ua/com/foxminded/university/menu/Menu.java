package ua.com.foxminded.university.menu;

import ua.com.foxminded.university.domain.ObjectFinder;
import ua.com.foxminded.university.domain.TestDataForUniversity;
import ua.com.foxminded.university.domain.University;
import ua.com.foxminded.university.text.TextUniversityMenu;

public class Menu {
	public static final String WRONG_INPUT = "------------------------------" + System.lineSeparator() + "Wrong input!"
			+ System.lineSeparator() + "------------------------------";
	public static final String CONTINUE_ADDING = "Do you want to continue adding(any button/enter for exit)?";
	public static final String CONTINUE_REMOVING = "Do you want to continue removing(any button/enter for exit)?";
	public static final String CONTINUE_CHANGING = "Do you want to continue changing(any button/enter for exit)?";
	public University university = new University();
	public TestDataForUniversity testDataForUniversity = new TestDataForUniversity(university);
	public TextUniversityMenu textMenu = new TextUniversityMenu();
	public ObjectFinder finder;

	public Menu() {
		testDataForUniversity.createDataForUniversity();
		finder = new ObjectFinder(university);
	}

	public Boolean checkIfBackMenu(String selectedOption) {
		return selectedOption.equals("p");
	}
}
