package org.persistencia.csv;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CSVCompression {
    private static final String CSV_FILE_NAME = "data.csv";

    public static void compress() {
        try {
            File zipFile = new File("data.zip");

            try (FileInputStream fileInputStream = new FileInputStream(CSV_FILE_NAME);
                 FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
                 ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {

                ZipEntry zipEntry = new ZipEntry(CSV_FILE_NAME);
                zipOutputStream.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fileInputStream.read(bytes)) >= 0) {
                    zipOutputStream.write(bytes, 0, length);
                }

                System.out.println("CSV file successfully compressed.");
            }
        } catch (IOException e) {
            System.err.println("Error compressing the CSV file: " + e.getMessage());
        }
    }
}
