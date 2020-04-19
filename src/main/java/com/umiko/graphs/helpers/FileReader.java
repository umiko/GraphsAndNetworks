package com.umiko.graphs.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<String> readFile(String path) {
        File f = new File(new FileReader().getClass().getClassLoader().getResource(path).getFile());
        return readFile(f);
    }

    public static ArrayList<String> readFile(File f) {
        if (!f.exists())
            throw new IllegalArgumentException("The path '" + f.getPath() + "' is not a valid file path.");

        try (java.io.FileReader fr = new java.io.FileReader(f); BufferedReader br = new BufferedReader(fr)) {
            String line;
            ArrayList<String> content = new ArrayList<>();
            while (null != (line = br.readLine())) {
                content.add(line);
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
