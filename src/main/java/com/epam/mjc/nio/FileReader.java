package com.epam.mjc.nio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String email= "";
        int age = 0;
        String name = "";
        Long phone = 0L;
        Path path = Paths.get(file.getAbsolutePath());
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String[] row = new String[4];
            String currentLine;
            int count = 0;

            while((currentLine = reader.readLine()) != null) {
                row[count] = currentLine;
                count ++;
            }

            HashMap<String, String> gatavs = new HashMap<>();
            for (String s : row) {
                String[] profileText = s.split(" ");
                gatavs.put(profileText[0], profileText[1]);
            }
            email = gatavs.get("Email:").trim();
            age = Integer.parseInt(gatavs.get("Age:").trim());
            name = gatavs.get("Name:").trim();
            phone = Long.parseLong(gatavs.get("Phone:").trim());

        }catch (IOException e){
            e.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}
