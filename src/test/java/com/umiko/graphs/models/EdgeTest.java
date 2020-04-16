package com.umiko.graphs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    private Edge e,f,g,h,i;

    @BeforeEach
    void setUp() {
        e = new Edge(1,2);
        f = new Edge(1,2,3);
        g = new Edge(1,2,false);
        h = new Edge(1,2,3, true);
        i = new Edge(3,4);
    }

    @Test
    void getFrom() {
        assertEquals(1, e.getFrom());
        assertEquals(3, i.getFrom());
    }

    @Test
    void getTo() {
        assertEquals(2, e.getTo());
        assertEquals(4, i.getTo());
    }

    @Test
    void getWeight() {
        assertEquals(1, e.getWeight());
        assertEquals(3, f.getWeight());
        assertEquals(3, h.getWeight());
    }

    @Test
    void isDirected() {
        assertFalse(e.isDirected());
        assertFalse(g.isDirected());
        assertTrue(h.isDirected());
    }

    @Test
    void isWeighted() {
        assertTrue(f.isWeighted());
        assertFalse(e.isWeighted());
    }

    @Test
    void contains() {
        assertTrue(e.contains(1));
        assertTrue(e.contains(2));
        assertFalse(e.contains(3));
    }

    @Test
    void getOther() {
        assertEquals(2, e.getOther(1));
        assertEquals(1, e.getOther(2));
        assertThrows(IllegalArgumentException.class, ()->{e.getOther(123);});
    }

    @Test
    void testEquals() {
        assertEquals(e, e);
        assertNotEquals(e,f);
        assertEquals(e,g);
        assertNotEquals(f,h);
    }

    @Test
    void testToString() {
        assertEquals("1 -- 2", e.toString());
        assertEquals("1 -> 2", h.toString());
    }
}