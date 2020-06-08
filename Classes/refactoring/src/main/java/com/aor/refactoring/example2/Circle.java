package com.aor.refactoring.example2;

import static java.lang.Math.pow;

public class Circle extends Shape {
    private double radius;
    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius=radius;
    }

    @Override
    public double getArea(){
        return Math.PI*pow(radius,2);
    }

    @Override
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    @Override
    public void draw(GraphicFramework graphics) {
        graphics.drawCircle(super.getX(), super.getY(), radius);
    }
}
