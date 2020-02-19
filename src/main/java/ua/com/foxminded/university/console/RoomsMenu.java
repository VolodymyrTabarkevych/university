package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Room;

public class RoomsMenu extends TextUniversityMenu {
    DbCooperator dbCooperator;

    public RoomsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showRoomsMenuOptions();
        try {
            String selectedOption = reader.readLine();
            switch (selectedOption) {
            case "p":
                break;
            case "a":
                do {
                    addRoom(reader);
                    selectedOption = reader.readLine();
                } while (!selectedOption.equals(""));
                break;
            case "b":
                do {
                    removeRoom(reader);
                    selectedOption = reader.readLine();
                } while (!selectedOption.equals(""));
                break;
            case "c":
                viewAllRooms();
                break;
            default:
                System.out.println(WRONG_INPUT);
            }
        } catch (IOException e) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void addRoom(BufferedReader reader) throws NumberFormatException, IOException {
        int roomNumber = Integer.parseInt(reader.readLine());
        // university.addNewRoom(roomNumber);
        System.out.println(CONTINUE_ADDING);
    }

    private void removeRoom(BufferedReader reader) throws NumberFormatException, IOException {
        int roomNumber = Integer.parseInt(reader.readLine());
        // university.removeRoom(roomNumber);
        System.out.println(CONTINUE_REMOVING);
    }

    private void viewAllRooms() {
        for (Room room : dbCooperator.getRoomDaoJdbcTemplateImpl().findAll()) {
            System.out.println(room.getNumber());
        }
    }
}
