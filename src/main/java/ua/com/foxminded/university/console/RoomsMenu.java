package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.foxminded.university.DbCooperator;
import ua.com.foxminded.university.domain.Room;

public class RoomsMenu extends TextUniversityMenu {
    private DbCooperator dbCooperator;
    private int rowsAffected = 0;
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
            rowsAffected = dbCooperator.getRoomDao().save(new Room(roomNumber));
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_ADDED);
            } else {
                System.out.println(DATA_HASNT_BEEN_ADDED);
            }
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeRoom(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter room id: ");
            int roomId = Integer.parseInt(reader.readLine());
            rowsAffected = dbCooperator.getRoomDao().delete(roomId);
            if (rowsAffected > 0) {
                System.out.println(DATA_HAS_BEEN_DELETED);
            } else {
                System.out.println(DATA_HASNT_BEEN_DELETED);
            }
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllRooms() {
        for (Room room : dbCooperator.getRoomDao().findAll()) {
            System.out.println(room.getNumber());
        }
    }
}
