package ua.com.foxminded.university.console;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.foxminded.university.domain.Room;
import ua.com.foxminded.university.exceptions.EntityNameExistsException;
import ua.com.foxminded.university.service.RoomService;

@Component
public class RoomsMenu extends TextUniversityMenu {
    private static final Logger logger = LoggerFactory.getLogger(RoomsMenu.class);
    private RoomService roomService;
    private String selectedOption = "";

    @Autowired
    public RoomsMenu(RoomService roomService) {
        this.roomService = roomService;
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
                    System.err.println(WRONG_INPUT);
            }
        } catch (IOException | NumberFormatException | EntityNameExistsException e) {
            logger.error(e.getMessage());
            System.err.println(WRONG_INPUT + e.getMessage());
        }
    }

    private void addRoom(BufferedReader reader) throws NumberFormatException, IOException, EntityNameExistsException {
        do {
            System.out.println("Enter room number: ");
            int roomNumber = Integer.parseInt(reader.readLine());
            roomService.addRoom(new Room(roomNumber));
            System.out.println(CONTINUE_ADDING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void removeRoom(BufferedReader reader) throws NumberFormatException, IOException {
        do {
            System.out.println("Enter room id: ");
            int roomId = Integer.parseInt(reader.readLine());
            roomService.removeRoom(roomId);
            System.out.println(CONTINUE_REMOVING);
            selectedOption = reader.readLine();
        } while (!selectedOption.equals(""));
    }

    private void viewAllRooms() {
        for (Room room : roomService.viewAllRooms()) {
            System.out.println(room.getNumber());
        }
    }
}
