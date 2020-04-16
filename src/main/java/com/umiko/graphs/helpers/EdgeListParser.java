package com.umiko.graphs.helpers;

import com.umiko.graphs.models.Edge;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public final class EdgeListParser {
    public static Collection<Edge> parse(File f){
        return parseStrings(FileReader.readFile(f));
    }

    public static Collection<Edge> parse(String filepath){
        return parseStrings(FileReader.readFile(filepath));
    }

    public static Collection<Edge> parseStrings(ArrayList<String> edgeStrings){
        Collection<Edge> edges = new ArrayList<>();

        edgeStrings.remove(0);
        edgeStrings.forEach(s -> edges.add(parseString(s)));
        return edges;
    }

    public static Edge parseString(String s){
        String[] splitString = s.split(" ");

        if(splitString.length == 2){
            return new Edge(Integer.parseInt(splitString[0]), Integer.parseInt(splitString[1]));
        }
        if(splitString.length == 3){
            return new Edge(Integer.parseInt(splitString[0]), Integer.parseInt(splitString[2]), Integer.parseInt(splitString[1]));
        }
        throw new IllegalArgumentException("String '" + s + "' is not a valid Edge.");
    }
}
