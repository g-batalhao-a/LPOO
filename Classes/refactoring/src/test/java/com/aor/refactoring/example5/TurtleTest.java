package com.aor.refactoring.example5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurtleTest {

    @Test
    public void testRotateLeft() {
        Turtle turtle = new Turtle(5, 5, new TurtleNorth());
        turtle.execute('L'); assertEquals('W', turtle.getDirection());
        turtle.execute('L'); assertEquals('S', turtle.getDirection());
        turtle.execute('L'); assertEquals('E', turtle.getDirection());
        turtle.execute('L'); assertEquals('N', turtle.getDirection());
        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testRotateRight() {
        Turtle turtle = new Turtle(5, 5, new TurtleNorth());
        turtle.execute('R'); assertEquals('E', turtle.getDirection());
        turtle.execute('R'); assertEquals('S', turtle.getDirection());
        turtle.execute('R'); assertEquals('W', turtle.getDirection());
        turtle.execute('R'); assertEquals('N', turtle.getDirection());
        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testForward() {
        Turtle turtleN = new Turtle(5, 5, new TurtleNorth());

        turtleN.execute('F');
        assertEquals(4, turtleN.getRow());
        assertEquals(5, turtleN.getColumn());

        Turtle turtleW = new Turtle(5, 5, new TurtleWest());

        turtleW.execute('F');
        assertEquals(5, turtleW.getRow());
        assertEquals(4, turtleW.getColumn());

        Turtle turtleS = new Turtle(5, 5, new TurtleSouth());

        turtleS.execute('F');
        assertEquals(6, turtleS.getRow());
        assertEquals(5, turtleS.getColumn());

        Turtle turtleE = new Turtle(5, 5, new TurtleEast());

        turtleE.execute('F');
        assertEquals(5, turtleE.getRow());
        assertEquals(6, turtleE.getColumn());
    }

}