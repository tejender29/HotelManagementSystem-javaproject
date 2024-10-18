package com.hotelmanagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class GuestService {

    private final Scanner scanner;
    private final ArrayList<Guest> guestList;

    public GuestService(Scanner scanner) {
        this.scanner = scanner;
        this.guestList = new ArrayList<>();
    }

    public void addGuest() {
        int id = getIntInput("Enter Guest Id");
        String name = getStringInput("Enter Guest Name:");
        String contactNumber = getStringInput("Enter Guest Contact Number:");

        Guest guest = new Guest(id, name, contactNumber);
        guestList.add(guest);
        System.out.println("Guest added successfully.");
    }

    public void listGuests() {
        if (guestList.isEmpty()) {
            System.out.println("No records found.");
        } else {
            guestList.forEach(System.out::println);
        }
    }

    public void deleteGuest() {
        int id = getIntInput("Enter Guest Id to delete:");
        Optional<Guest> guest = findGuestById(id);

        if (guest.isPresent() && guestList.remove(guest.get())) {
            System.out.println("Guest record deleted successfully.");
        } else {
            System.out.println("Guest record not found.");
        }
    }

    private Optional<Guest> findGuestById(int id) {
        return guestList.stream()
                .filter(guest -> guest.getId() == id)
                .findFirst();
    }

    public void updateGuest() {
        int id = getIntInput("Enter Guest Id to update:");
        Optional<Guest> guest = findGuestById(id);

        if (guest.isPresent()) {
            String name = getStringInput("Enter New Guest Name:");
            String contactNumber = getStringInput("Enter New Guest Contact Number:");

            guest.get().setName(name);
            guest.get().setContactNumber(contactNumber);
            System.out.println("Guest updated successfully.");
        } else {
            System.out.println("Guest not found.");
        }
    }

    // Change access modifier to public
    public int getIntInput(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private String getStringInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
