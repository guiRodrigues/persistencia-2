package org.persistencia.csv;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class CSVHashing {
    private static final String CSV_FILE_NAME = "data.csv";

    public static void calculateHash() {
        try {
            FileInputStream fileInputStream = new FileInputStream(CSV_FILE_NAME);
            String sha256 = DigestUtils.sha256Hex(fileInputStream);
            fileInputStream.close();

            System.out.println("SHA256 hash of the CSV file: " + sha256);
        } catch (IOException e) {
            System.err.println("Error calculating the SHA256 hash: " + e.getMessage());
        }
    }
}
