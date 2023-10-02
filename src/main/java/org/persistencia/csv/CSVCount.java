package org.persistencia.csv;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class CSVCount {
    private static final String CSV_FILE_NAME = "data.csv";

    public static void showEntityCount() {
        try {
            int lineNumber = getLineCount(CSV_FILE_NAME);
            System.out.println("Number of entities in the CSV file: " + lineNumber);
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    private static int getLineCount(String fileName) throws IOException {
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(fileName))) {
            while (lnr.readLine() != null) {
                // Empty loop body
            }
            return lnr.getLineNumber();
        }
    }
}
