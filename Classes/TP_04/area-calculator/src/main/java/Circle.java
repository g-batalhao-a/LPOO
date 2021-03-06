public class Circle implements AreaShape {
    private int radius;
    public Circle(int radius){
        this.radius=radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(this.radius,2);
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
