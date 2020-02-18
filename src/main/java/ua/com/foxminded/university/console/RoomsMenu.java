package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

public class RoomsMenu extends Menu {
    public void start(BufferedReader reader) {
        textMenu.showRoomsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            if (Boolean.FALSE.equals(checkIfReturnMenu(selectedOption)) && selectedOption.equals("a")
                    || selectedOption.equals("b") || selectedOption.equals("c")) {
                if (selectedOption.equals("a")) {
                    do {
                        int roomNumber = Integer.parseInt(reader.readLine());
                        // university.addNewRoom(roomNumber);
                        System.out.println(CONTINUE_ADDING);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else if (selectedOption.equals("b")) {
                    do {
                        int roomNumber = Integer.parseInt(reader.readLine());
                        // university.removeRoom(roomNumber);
                        System.out.println(CONTINUE_REMOVING);
                        selectedOption = reader.readLine();
                    } while (!selectedOption.equals(""));
                } else {
                    viewer.viewAllRooms();
                }
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

}
