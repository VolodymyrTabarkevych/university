package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Room;

public class RoomsMenu extends TextUniversityMenu {
    private DbCooperator dbCooperator;
    private String selectedOption = "";

    public RoomsMenu(DbCooperator dbCooperator) {
        this.dbCooperator = dbCooperator;
    }

    public void start(BufferedReader reader) {
        showRoomsMenuOptions();
        try {
            selectedOption = reader.readLine();
            switch (selectedOption) {
            case "p":
                break;
            case "a":
                addRoom(reader);
                break;
            case "b":
                removeRoom(reader);
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
        do {
            System.out.println("Enter room number: ");
            int roomNumber = Integer.parseInt(reader.readLine());
            dbCooperator.getRoomDaoJdbcTemplateImpl().save(new Room(roomNumber));
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeRoom(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter room id: ");
            int roomId = Integer.parseInt(reader.readLine());
            dbCooperator.getRoomDaoJdbcTemplateImpl().delete(roomId);
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllRooms() {
        for (Room room : dbCooperator.getRoomDaoJdbcTemplateImpl().findAll()) {
            System.out.println(room.getNumber());
        }
    }
}
