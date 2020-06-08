package com.aor.refactoring.example5;

public class TurtleWest implements Direction{
    private Turtle turtle;

    public TurtleWest(){

    }
    public TurtleWest(Turtle turtle){
        this.turtle=turtle;
    }

    @Override
    public void rotateRight() {
        turtle.setDirection(new TurtleNorth(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setDirection(new TurtleSouth(turtle));
    }

    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn()-1);
    }

    @Override
    public void setTurtle(Turtle turtle) {
        this.turtle=turtle;
    }

    @Override
    public char getDirection() {
        return 'W';
    }
}
