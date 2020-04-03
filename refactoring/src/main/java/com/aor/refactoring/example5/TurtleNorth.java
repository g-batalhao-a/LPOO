package com.aor.refactoring.example5;

public class TurtleNorth implements Direction {
    private Turtle turtle;

    public TurtleNorth(){}

    public TurtleNorth(Turtle turtle){
        this.turtle=turtle;
    }
    @Override
    public void rotateRight() {
        turtle.setDirection(new TurtleEast(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setDirection(new TurtleWest(turtle));
    }

    @Override
    public void moveForward() {
        turtle.setRow(turtle.getRow()-1);
    }

    @Override
    public void setTurtle(Turtle turtle) {
        this.turtle=turtle;
    }

    @Override
    public char getDirection() {
        return 'N';
    }
}
