package com.umiko.graphs.helpers;

import com.umiko.graphs.models.Edge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EdgeListParserTest {

    String[] parseThese = {"", "1", "1 2", "1 4 5", "1 8 7 6", "nan ,wq"};

    @BeforeEach
    void setUp() {
    }

//    @Test
//    void parse() {
//        assertEquals(new ArrayList<Edge>(List.of(new Edge(1, 2))), EdgeListParser.parse(Constants.filePaths[2]));
//        assertEquals(new ArrayList<Edge>(List.of(
//                new Edge(1, 4),
//                new Edge(1, 5),
//                new Edge(1, 6),
//                new Edge(2, 4),
//                new Edge(2, 5),
//                new Edge(2, 6),
//                new Edge(3, 4),
//                new Edge(3, 5),
//                new Edge(3, 6)
//        )),EdgeListParser.parse(Constants.filePaths[3]));
//        assertEquals(new ArrayList<Edge>(List.of(
//                new Edge(1, 4, 4),
//                new Edge(1, 5, 5),
//                new Edge(1, 6, 6),
//                new Edge(2, 4, 4),
//                new Edge(2, 5, 5),
//                new Edge(2, 6, 6),
//                new Edge(3, 4, 4),
//                new Edge(3, 5, 5),
//                new Edge(3, 6, 6)
//        )),EdgeListParser.parse(Constants.filePaths[4]));
//    }
//
//    @Test
//    void parseStrings() {
//        assertEquals(new ArrayList<Edge>(List.of(
//                new Edge(1, 4, 4),
//                new Edge(1, 5, 5),
//                new Edge(1, 6, 6),
//                new Edge(2, 4, 4),
//                new Edge(2, 5, 5),
//                new Edge(2, 6, 6),
//                new Edge(3, 4, 4),
//                new Edge(3, 5, 5),
//                new Edge(3, 6, 6)
//        )),EdgeListParser.parseStrings(FileReader.readFile(Constants.filePaths[4])));
//    }

    @Test
    void parseString() {
        assertThrows(IllegalArgumentException.class, () -> {
            EdgeListParser.parseString(parseThese[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            EdgeListParser.parseString(parseThese[1]);
        });
        assertEquals(new Edge(1, 2), EdgeListParser.parseString(parseThese[2]));
        assertEquals(new Edge(1, 5, 4), EdgeListParser.parseString(parseThese[3]));
        assertThrows(IllegalArgumentException.class, () -> {
            EdgeListParser.parseString(parseThese[4]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            EdgeListParser.parseString(parseThese[5]);
        });
    }
}