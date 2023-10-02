package org.persistencia.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVInsertion {
    private static final String CSV_FILE_NAME = "data.csv";

    public static void insertEntity(Scanner scanner) {
        try (FileWriter fw = new FileWriter(CSV_FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            System.out.print("Enter the data to be inserted (comma-separated): ");
            scanner.nextLine(); // Consume the newline character from the previous input
            String data = scanner.nextLine(); // Read the entire line as-is
            pw.println(data);

            System.out.println("Data successfully inserted into the CSV file.");
        } catch (IOException e) {
            System.err.println("Error inserting data into the CSV file: " + e.getMessage());
        }
    }
}
