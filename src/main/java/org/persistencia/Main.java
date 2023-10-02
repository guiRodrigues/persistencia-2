package org.persistencia;
import org.persistencia.csv.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    CSVInsertion.insertEntity(scanner);
                    break;
                case 2:
                    CSVCount.showEntityCount();
                    break;
                case 3:
                    CSVConversion.convertCSVToJSONAndXML();
                    break;
                case 4:
                    CSVCompression.compress();
                    break;
                case 5:
                    CSVHashing.calculateHash();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Insert entity into CSV file");
        System.out.println("2. Show the number of entities in the CSV file");
        System.out.println("3. Convert CSV data to JSON and XML files");
        System.out.println("4. Compress the CSV file");
        System.out.println("5. Calculate SHA256 hash of the CSV file");
        System.out.println("6. Exit");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }
}
