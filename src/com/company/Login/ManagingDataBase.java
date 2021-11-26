package com.company.Login;
import com.sun.source.tree.CompilationUnitTree;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ManagingDataBase {

    public ManagingDataBase(Map<String, String> username) {

    }

    public ManagingDataBase() {


    }



    public static void writeIntoDataBase(Map<String, String> usernameDataBase) throws IOException {

        List<String> usernames = new ArrayList<>(usernameDataBase.keySet());
        //List<String> passwords = new ArrayList<>(usernameDataBase.);

        List<List<String>> rows = new ArrayList<>();
        for(Map.Entry entry: usernameDataBase.entrySet()){
            String.join(entry.getKey(), ",", entry.getValue());

            Arrays.asList(entry.getKey(), entry.getValue());

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

            csvWriter.flush();
        }
    }
        public static Map<String , String> readIntoDataBase() throws IOException {
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

}
