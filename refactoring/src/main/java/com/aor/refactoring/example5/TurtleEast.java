package com.aor.refactoring.example5;

public class TurtleEast implements Direction {
    private Turtle turtle;

    public TurtleEast(){}

    public TurtleEast(Turtle turtle){
        this.turtle=turtle;
    }

    @Override
    public void rotateRight() {
        turtle.setDirection(new TurtleSouth(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setDirection(new TurtleNorth(turtle));
    }

    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn()+1);
    }

    @Override
    public void setTurtle(Turtle turtle) {
        this.turtle=turtle;
    }

    @Override
    public char getDirection() {
        return 'E';
    }
}
