package org.persistencia.csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.persistencia.models.Entry;
import org.persistencia.models.User;
import org.persistencia.models.Vault;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CSVConversion {
    private static final String CSV_FILE_NAME = "data.csv";

    public static void convertCSVToJSONAndXML() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            File jsonFile = new File("data.json");
            File xmlFile = new File("data.xml");

            // Create a mapping of entity type values to their corresponding class constructors
            Map<Integer, Class<?>> entityMapping = new HashMap<>();
            entityMapping.put(1, User.class);
            entityMapping.put(2, Entry.class);
            entityMapping.put(3, Vault.class);

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CSV_FILE_NAME));
                 FileWriter jsonWriter = new FileWriter(jsonFile);
                 FileWriter xmlWriter = new FileWriter(xmlFile)) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length > 0) {
                        int entityType = Integer.parseInt(parts[0]);

                        // Check if the entityType is in the mapping
                        if (entityMapping.containsKey(entityType)) {
                            Class<?> entityClass = entityMapping.get(entityType);

                            // Create an instance of the corresponding class using reflection
                            Object entity = entityClass.getDeclaredConstructor().newInstance();

                            // Populate the fields of the entity based on the CSV data
                            Field[] fields = entityClass.getDeclaredFields();

                            // Assuming that the CSV data corresponds to fields in the same order
                            for (int i = 1; i < parts.length && i - 1 < fields.length; i++) {
                                Field field = fields[i - 1];
                                field.setAccessible(true);
                                Class<?> fieldType = field.getType();

                                // Convert the CSV string to the appropriate field type
                                if (fieldType == int.class || fieldType == Integer.class) {
                                    field.set(entity, Integer.parseInt(parts[i]));
                                } else if (fieldType == String.class) {
                                    field.set(entity, parts[i]);
                                }
                            }

                            // Convert to JSON
                            String json = objectMapper.writeValueAsString(entity);
                            jsonWriter.write(json + "\n");

                            // Convert to XML
                            String xml = xmlMapper.writeValueAsString(entity);
                            xmlWriter.write(xml + "\n");
                        }
                    }
                }

                System.out.println("CSV file data successfully converted to JSON and XML.");
            }
        } catch (Exception e) {
            System.err.println("Error converting data to JSON and XML: " + e.getMessage());
        }
    }
}
