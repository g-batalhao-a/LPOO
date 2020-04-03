package com.aor.refactoring.example5;

public interface Direction {
    void rotateRight();
    void rotateLeft();
    void moveForward();
    void setTurtle(Turtle turtle);
    char getDirection();
}
