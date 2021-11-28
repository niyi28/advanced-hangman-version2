package com.company.Login;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ManagingDataBase {

    private static void writeIntoDataBase(Map<String, String> usernameDataBase) throws IOException {
        List<List<String>> rows = new ArrayList<>();
        for(Map.Entry<String, String> entry: usernameDataBase.entrySet()){
            rows.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        String path = "src/com/company/Login/DataBase/database.csv";
        createOrMaintainDirectory(path);
        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path))) {
            csvWriter.append("Username");
            csvWriter.append(",");
            csvWriter.append("Password");
            csvWriter.append("\n");
            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }
        }
    }
        public static Map<String , String> readIntoDataBase() throws IOException {
            Map<String, String> userDataBase = new HashMap<>();

            String path = "src/com/company/Login/DataBase/database.csv";
            createOrMaintainDirectory(path);
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                int counter = 0;
                while ((line = reader.readLine()) != null) {
                    counter++;
                    if (counter > 1) {
                        String[] x = line.split(",");
                        userDataBase.put(x[0], x[1]);

                    }
                }
            }
            return userDataBase;
        }

        public static void addUser(String name, String password) throws IOException {
           Map<String, String> x = readIntoDataBase();
           x.put(name, password);
           writeIntoDataBase(x);
        }

        public static boolean isUserExists(String name) throws IOException {
            Map<String, String> x = readIntoDataBase();
             return x.containsKey(name.toLowerCase());
        }

        public static String getUsersPassword(String username) throws IOException {
            Map<String, String> x = readIntoDataBase();
            return x.get(username.toLowerCase());
        }
        private static void createOrMaintainDirectory(String path) throws IOException {
        File csvFile = new File(path);
        csvFile.getParentFile().mkdirs();
        csvFile.createNewFile();
            /*if (!csvFile.exists()) {
                Path pathCheck = Paths.get(path);
                Files.createDirectories(pathCheck);
                *//*File parentFile = csvFile.getParentFile();*//*
                *//*parentFile.mkdirs();
                csvFile.createNewFile();*//*
            }*/
        }



}
