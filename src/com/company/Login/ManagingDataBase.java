package com.company.Login;
import com.sun.source.tree.CompilationUnitTree;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ManagingDataBase {

    private static void writeIntoDataBase(Map<String, String> usernameDataBase) throws IOException {

        List<List<String>> rows = new ArrayList<>();
        for(Map.Entry<String, String> entry: usernameDataBase.entrySet()){
            rows.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }


        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter("src/com/company/Login/DataBase/database.csv"))) {
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
         static Map<String , String> readIntoDataBase() throws IOException {
            Map<String, String> userDataBase = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("src/com/company/Login/DataBase/database.csv"))) {
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

}
