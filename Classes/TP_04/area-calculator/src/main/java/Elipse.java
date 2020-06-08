public class Elipse implements AreaShape {
    private int x_radius, y_radius;
    public Elipse(int x_radius,int y_radius){
        this.x_radius=x_radius;this.y_radius=y_radius;
    }

    public void setY_radius(int y_radius) {
        this.y_radius = y_radius;
    }

    public void setX_radius(int x_radius) {
        this.x_radius = x_radius;
    }

    public int getY_radius() {
        return y_radius;
    }

    public int getX_radius() {
        return x_radius;
    }

    @Override
    public double getArea() {
        return Math.PI*this.y_radius*this.x_radius;
    }

    @Override
    public void draw() {
        System.out.println("Elipse");
    }
}

