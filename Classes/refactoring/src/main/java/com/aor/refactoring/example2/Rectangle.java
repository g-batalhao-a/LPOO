package com.aor.refactoring.example2;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height){
        super(x,y);
        this.width=width;
        this.height=height;
    }

    @Override
    public double getArea(){
        return width*height;
    }

    @Override
    public double getPerimeter(){
        return 2*(width+height);
    }

    @Override
    public void draw(GraphicFramework graphics) {
        graphics.drawLine(super.getX(), super.getY(), super.getX() + width, super.getY());
        graphics.drawLine(super.getX() + width, super.getY(), super.getX() + width, super.getY() + height);
        graphics.drawLine(super.getX() + width, super.getY() + height, super.getX(), super.getY() + height);
        graphics.drawLine(super.getX(), super.getY() + height, super.getX(), super.getY());
    }
}
