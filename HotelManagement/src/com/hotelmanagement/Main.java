package com.hotelmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            GuestService guestService = new GuestService(scanner);

            while (true) {
                System.out.println("1. Add Guest");
                System.out.println("2. List Guests");
                System.out.println("3. Delete Guest");
                System.out.println("4. Update Guest");
                System.out.println("5. Exit");

                int choice = guestService.getIntInput("Choose an option:");
                switch (choice) {
                    case 1:
                        guestService.addGuest();
                        break;
                    case 2:
                        guestService.listGuests();
                        break;
                    case 3:
                        guestService.deleteGuest();
                        break;
                    case 4:
                        guestService.updateGuest();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
